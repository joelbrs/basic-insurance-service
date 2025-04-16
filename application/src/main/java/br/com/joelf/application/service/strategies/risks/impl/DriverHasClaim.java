package br.com.joelf.application.service.strategies.risks.impl;

import br.com.joelf.application.service.strategies.risks.RiskManagementStrategy;
import br.com.joelf.domain.port.ClaimRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class DriverHasClaim implements RiskManagementStrategy {

    private final ClaimRepository claimRepository;

    @Override
    public BigDecimal verify(Long customerId, Long carId) {
        boolean hasClaims = claimRepository.driverHasClaimByCustomerId(customerId);
        return hasClaims ? RiskManagementStrategy.STANDARD_RISK_PERCENTAGE : BigDecimal.ZERO;
    }
}
