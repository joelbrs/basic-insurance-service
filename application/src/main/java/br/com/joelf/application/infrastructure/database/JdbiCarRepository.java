package br.com.joelf.application.infrastructure.database;

import br.com.joelf.application.mapper.CarRowMapper;
import br.com.joelf.application.mapper.DriverRowMapper;
import br.com.joelf.domain.domain.Car;
import br.com.joelf.domain.domain.Driver;
import br.com.joelf.domain.port.CarRepository;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

@UseClasspathSqlLocator
public interface JdbiCarRepository extends CarRepository {

    @Override
    @SqlQuery
    @UseRowMapper(DriverRowMapper.class)
    Driver getMainDriver(Long carId);

    @Override
    @SqlQuery
    @UseRowMapper(CarRowMapper.class)
    Car getDetails(Long carId);
}
