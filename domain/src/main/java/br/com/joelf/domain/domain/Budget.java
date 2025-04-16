package br.com.joelf.domain.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Budget {
    private Long id;
    private Long customerId;
    private Long carId;
    private BigDecimal basedFipeValue;
    private BigDecimal standardAliquot;
    private BigDecimal riskManagementAdditional;
}
