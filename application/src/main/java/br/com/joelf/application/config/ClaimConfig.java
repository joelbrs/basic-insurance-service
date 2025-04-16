package br.com.joelf.application.config;

import br.com.joelf.domain.port.ClaimRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClaimConfig {

    @Bean
    public ClaimRepository claimRepository() {
        return new ClaimRepository() {
            @Override
            public boolean driverHasClaim(String document) {
                return false;
            }

            @Override
            public boolean carHasClaim(Long carId) {
                return false;
            }
        };
    }
}
