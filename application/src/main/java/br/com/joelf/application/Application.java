package br.com.joelf.application;

import br.com.joelf.domain.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Application implements CommandLineRunner {

    private final BudgetService budgetService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("should be 6.00, equals: " + budgetService.getRiskFactor("11122233344", 3L));
        System.out.println("should be 8.00 - age is equal 20, equals: " + budgetService.getRiskFactor("55566677788", 4L));
        System.out.println("should be 10.00 - car's claims and driver's claims, equals: " + budgetService.getRiskFactor("12345678900", 1L));
        System.out.println("should be 12.00 - everything, equals: " + budgetService.getRiskFactor("98765432100", 2L));
    }
}
