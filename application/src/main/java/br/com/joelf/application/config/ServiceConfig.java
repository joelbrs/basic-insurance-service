package br.com.joelf.application.config;

import br.com.joelf.application.service.BudgetServiceImpl;
import br.com.joelf.domain.domain.Budget;
import br.com.joelf.domain.port.CacheRepository;
import br.com.joelf.domain.port.CarRepository;
import br.com.joelf.domain.port.ClaimRepository;
import br.com.joelf.domain.service.BudgetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public BudgetService budgetService(
            CarRepository carRepository,
            ClaimRepository claimRepository,
            CacheRepository<String, Budget> budgetCache
    ) {
        return new BudgetServiceImpl(carRepository, claimRepository, budgetCache);
    }
}
