package br.com.joelf.domain.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Car {
    private Long id;
    private String model;
    private String manufacturer;
    private Integer year;
    private BigDecimal fipeValue;
}
