package br.com.joelf.application.infrastructure.database;

import br.com.joelf.domain.domain.Driver;
import br.com.joelf.domain.port.CarRepository;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

@UseClasspathSqlLocator
public interface JdbiCarRepository extends CarRepository {

    @Override
    @SqlQuery
    Driver getMainDriver(Long carId);
}
