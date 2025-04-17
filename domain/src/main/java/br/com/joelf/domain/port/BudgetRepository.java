package br.com.joelf.domain.port;

import br.com.joelf.domain.domain.Budget;

public interface BudgetRepository {
    Long create(Budget budget);
}
