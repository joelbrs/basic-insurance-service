package br.com.joelf.application.service.strategies.risks.impl;

import br.com.joelf.application.service.strategies.risks.RiskManagementStrategy;
import br.com.joelf.domain.domain.Driver;
import br.com.joelf.domain.port.CarRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
public class MainDriverIsYoungAge implements RiskManagementStrategy {

    private static final Integer LOWER_LIMIT_YEARS = 18;
    private static final Integer UPPER_LIMIT_YEARS = 25;

    private final CarRepository carRepository;

    @Override
    public BigDecimal verify(String driverDocument, Long carId) {
        Driver mainDriver = carRepository.getMainDriver(carId);

        if (mainDriver != null) {
            LocalDate today = LocalDate.now();
            LocalDate lowerLimit = today.minusYears(LOWER_LIMIT_YEARS);
            LocalDate upperLimit = today.minusYears(UPPER_LIMIT_YEARS);

            LocalDate mainDriverBirthDate = mainDriver.getBirthDate();

            boolean isDriverBirthdayHigherOrEqualThanLowerLimit =
                    mainDriverBirthDate.isBefore(lowerLimit) || mainDriverBirthDate.isEqual(lowerLimit);
            boolean isDriverBirthdayLowerOrEqualThanUpperLimit =
                    mainDriverBirthDate.isAfter(upperLimit) || mainDriverBirthDate.isEqual(upperLimit);

            if (isDriverBirthdayHigherOrEqualThanLowerLimit && isDriverBirthdayLowerOrEqualThanUpperLimit) {
                return RiskManagementStrategy.STANDARD_RISK_PERCENTAGE;
            }
        }
        return BigDecimal.ZERO;
    }
}
