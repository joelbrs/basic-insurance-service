package br.com.joelf.application.service.strategies.risks.impl;

import br.com.joelf.application.service.strategies.risks.RiskManagementStrategy;
import br.com.joelf.domain.port.ClaimRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class DriverHasClaim implements RiskManagementStrategy {

    private final ClaimRepository claimRepository;

    @Override
    public BigDecimal verify(String driverDocument, Long carId) {
        boolean hasClaims = claimRepository.driverHasClaim(driverDocument);
        return hasClaims ? RiskManagementStrategy.STANDARD_RISK_PERCENTAGE : BigDecimal.ZERO;
    }
}
