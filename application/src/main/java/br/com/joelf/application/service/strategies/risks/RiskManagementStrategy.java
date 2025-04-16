package br.com.joelf.application.service.strategies.risks;

import java.math.BigDecimal;

public interface RiskManagementStrategy {
    BigDecimal STANDARD_RISK_PERCENTAGE = BigDecimal.TWO;

    BigDecimal verify(Long customerId, Long carId);
}
