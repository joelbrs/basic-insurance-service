package br.com.joelf.application.service;

import br.com.joelf.application.service.strategies.risks.RiskManagementStrategy;
import br.com.joelf.application.service.strategies.risks.impl.CarHasClaim;
import br.com.joelf.application.service.strategies.risks.impl.DriverHasClaim;
import br.com.joelf.application.service.strategies.risks.impl.MainDriverIsYoungAge;
import br.com.joelf.domain.port.CarRepository;
import br.com.joelf.domain.port.ClaimRepository;
import br.com.joelf.domain.service.InsuranceService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InsuranceServiceImpl implements InsuranceService {

    private static final BigDecimal STANDARD_ALIQUOTE = BigDecimal.valueOf(6L);
    private final List<RiskManagementStrategy> RISKS_MANAGEMENT = new ArrayList<>();

    private final CarRepository carRepository;
    private final ClaimRepository claimRepository;

    public InsuranceServiceImpl(
            CarRepository carRepository,
            ClaimRepository claimRepository
    ) {
        this.carRepository = carRepository;
        this.claimRepository = claimRepository;

        this.populateInsuranceStrategy();
    }

    @Override
    public BigDecimal getRiskFactor(String driverDocument, Long carId) {
        BigDecimal insuranceBrandFactor = STANDARD_ALIQUOTE;

        for (RiskManagementStrategy riskManagement : RISKS_MANAGEMENT) {
            BigDecimal additionalRiskFactor = riskManagement.verify(driverDocument, carId);
            insuranceBrandFactor = insuranceBrandFactor.add(additionalRiskFactor);
        }
        return insuranceBrandFactor;
    }

    private void populateInsuranceStrategy() {
        RISKS_MANAGEMENT.add(new CarHasClaim(claimRepository));
        RISKS_MANAGEMENT.add(new DriverHasClaim(claimRepository));
        RISKS_MANAGEMENT.add(new MainDriverIsYoungAge(carRepository));
    }
}
