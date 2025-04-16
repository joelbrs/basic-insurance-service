package br.com.joelf.domain.service;

import java.math.BigDecimal;

public interface BudgetService {
    BigDecimal getRiskFactor(String driverDocument, Long carId);
}
