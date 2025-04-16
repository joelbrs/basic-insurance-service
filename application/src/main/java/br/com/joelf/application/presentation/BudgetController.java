package br.com.joelf.application.presentation;

import br.com.joelf.application.presentation.dtos.budget.CreateBudgetDto;
import br.com.joelf.application.presentation.dtos.budget.UpdateBudgetDto;
import br.com.joelf.domain.domain.Budget;
import br.com.joelf.domain.service.BudgetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/budget")
public class BudgetController {

    private final BudgetService budgetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Budget createBudget(@RequestBody @Valid CreateBudgetDto budget) {
        return budgetService.createBudget(budget.customerId(), budget.carId());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Budget updateBudget(@PathVariable Long id, @RequestBody @Valid UpdateBudgetDto budget) {
        return budgetService.updateBudget(id, budget.carId());
    }
}
