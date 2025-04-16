package br.com.joelf.domain.service;

import br.com.joelf.domain.domain.Budget;

import java.math.BigDecimal;

public interface BudgetService {
    BigDecimal getRiskFactor(Long customerId, Long carId);
    Budget createBudget(Long customerId, Long carId);
}
