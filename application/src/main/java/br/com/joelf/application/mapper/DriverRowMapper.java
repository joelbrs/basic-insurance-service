package br.com.joelf.application.mapper;

import br.com.joelf.domain.domain.Driver;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DriverRowMapper implements RowMapper<Driver> {

    @Override
    public Driver map(ResultSet rs, StatementContext ctx) throws SQLException {
        return Driver.builder()
                .id(rs.getLong("id"))
                .document(rs.getString("document"))
                .birthDate(rs.getObject("birthdate", LocalDate.class))
                .build();
    }
}
