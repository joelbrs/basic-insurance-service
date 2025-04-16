package br.com.joelf.domain.port;

import br.com.joelf.domain.domain.Car;
import br.com.joelf.domain.domain.Driver;

public interface CarRepository {
    Driver getMainDriver(Long carId);
    Car getDetails(Long carId);
}
