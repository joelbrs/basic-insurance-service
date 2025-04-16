package br.com.joelf.application.config;

import br.com.joelf.application.service.InsuranceServiceImpl;
import br.com.joelf.domain.port.CarRepository;
import br.com.joelf.domain.port.ClaimRepository;
import br.com.joelf.domain.service.InsuranceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsuranceConfig {

    @Bean
    public InsuranceService insuranceService(
            CarRepository carRepository,
            ClaimRepository claimRepository
    ) {
        return new InsuranceServiceImpl(carRepository, claimRepository);
    }
}
