package br.com.joelf.application.service;

import br.com.joelf.application.service.strategies.risks.RiskManagementStrategy;
import br.com.joelf.application.service.strategies.risks.impl.CarHasClaim;
import br.com.joelf.application.service.strategies.risks.impl.DriverHasClaim;
import br.com.joelf.application.service.strategies.risks.impl.MainDriverIsYoungAge;
import br.com.joelf.domain.domain.Budget;
import br.com.joelf.domain.domain.Car;
import br.com.joelf.domain.port.CacheRepository;
import br.com.joelf.domain.port.CarRepository;
import br.com.joelf.domain.port.ClaimRepository;
import br.com.joelf.domain.service.BudgetService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BudgetServiceImpl implements BudgetService {

    private static final BigDecimal STANDARD_ALIQUOTE = BigDecimal.valueOf(6L);
    private final List<RiskManagementStrategy> RISKS_MANAGEMENT = new ArrayList<>();

    private final CarRepository carRepository;
    private final ClaimRepository claimRepository;
    private final CacheRepository<Long, Budget> budgetCache;

    public BudgetServiceImpl(
            CarRepository carRepository,
            ClaimRepository claimRepository,
            CacheRepository<Long, Budget> budgetCache
    ) {
        this.carRepository = carRepository;
        this.claimRepository = claimRepository;
        this.budgetCache = budgetCache;

        this.populateInsuranceStrategy();
    }

    @Override
    public BigDecimal getRiskFactor(Long customerId, Long carId) {
        BigDecimal insuranceBrandFactor = STANDARD_ALIQUOTE;

        for (RiskManagementStrategy riskManagement : RISKS_MANAGEMENT) {
            BigDecimal additionalRiskFactor = riskManagement.verify(customerId, carId);
            insuranceBrandFactor = insuranceBrandFactor.add(additionalRiskFactor);
        }
        return insuranceBrandFactor;
    }

    @Override
    public Budget createBudget(Long customerId, Long carId) {
        BigDecimal additionalRiskFactor = getRiskFactor(customerId, carId);
        Car carDetails = carRepository.getDetails(carId);

        Budget budget = Budget.builder()
                .customerId(new Random().nextLong())
                .standardAliquot(STANDARD_ALIQUOTE)
                .carId(carId)
                .basedFipeValue(carDetails.getFipeValue())
                .riskManagementAdditional(additionalRiskFactor)
                .build();

        budgetCache.set(budget.getId(), budget);
        return budget;
    }

    private void populateInsuranceStrategy() {
        RISKS_MANAGEMENT.add(new CarHasClaim(claimRepository));
        RISKS_MANAGEMENT.add(new DriverHasClaim(claimRepository));
        RISKS_MANAGEMENT.add(new MainDriverIsYoungAge(carRepository));
    }
}
