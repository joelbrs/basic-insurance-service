package br.com.joelf.domain.port;

import br.com.joelf.domain.domain.Driver;

public interface DriverRepository {
    boolean isMainDriver(String document, Long carId);
    Driver getDriverDetails(String document);
}
