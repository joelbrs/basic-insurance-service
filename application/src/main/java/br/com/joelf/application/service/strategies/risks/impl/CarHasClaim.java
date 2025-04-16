package br.com.joelf.application.service.strategies.risks.impl;

import br.com.joelf.application.service.strategies.risks.RiskManagementStrategy;
import br.com.joelf.domain.port.ClaimRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CarHasClaim implements RiskManagementStrategy {

    private final ClaimRepository claimRepository;

    @Override
    public BigDecimal verify(String driverDocument, Long carId) {
        boolean hasClaim = claimRepository.carHasClaim(carId);
        return hasClaim ? RiskManagementStrategy.STANDARD_RISK_PERCENTAGE : BigDecimal.ZERO;
    }
}
