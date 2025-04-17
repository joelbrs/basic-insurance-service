package br.com.joelf.application.infrastructure.database;

import br.com.joelf.domain.domain.Budget;
import br.com.joelf.domain.port.BudgetRepository;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

@UseClasspathSqlLocator
public interface JdbiBudgetRepository extends BudgetRepository {

    @Override
    @SqlUpdate
    @GetGeneratedKeys
    Long create(@BindBean Budget budget);
}
