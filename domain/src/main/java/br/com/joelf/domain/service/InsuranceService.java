package br.com.joelf.domain.service;

import java.math.BigDecimal;

public interface InsuranceService {
    BigDecimal getRiskFactor(String driverDocument, Long carId);
}
