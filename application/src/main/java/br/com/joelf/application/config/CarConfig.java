package br.com.joelf.application.config;

import br.com.joelf.domain.domain.Driver;
import br.com.joelf.domain.port.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean
    public CarRepository carRepository() {
        return new CarRepository() {
            @Override
            public Driver getMainDriver(Long carId) {
                return null;
            }
        };
    }
}
