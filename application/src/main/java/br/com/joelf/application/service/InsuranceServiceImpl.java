package br.com.joelf.application.service;

import br.com.joelf.domain.domain.Insurance;
import br.com.joelf.domain.service.BudgetService;
import br.com.joelf.domain.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final BudgetService budgetService;

    @Transactional
    @Override
    public Insurance createInsurance(Insurance insurance) {
        budgetService.createBudgetDomain(insurance.getBudgetId());
        //TODO: add insurance's insert in database
        return null;
    }
}
