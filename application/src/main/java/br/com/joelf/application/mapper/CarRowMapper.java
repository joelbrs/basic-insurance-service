package br.com.joelf.application.mapper;

import br.com.joelf.domain.domain.Car;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {
        return Car.builder()
                .id(rs.getLong("id"))
                .model(rs.getString("model"))
                .year(rs.getInt("years"))
                .fipeValue(BigDecimal.valueOf(rs.getDouble("fipe_value")))
                .manufacturer(rs.getString("manufacturer"))
                .build();
    }
}
