package br.com.joelf.application.infrastructure.database;

import br.com.joelf.domain.port.ClaimRepository;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

@UseClasspathSqlLocator
public interface JdbiClaimRepository extends ClaimRepository {

    @Override
    @SqlQuery
    boolean driverHasClaim(String document);

    @Override
    @SqlQuery
    boolean carHasClaim(Long carId);
}
