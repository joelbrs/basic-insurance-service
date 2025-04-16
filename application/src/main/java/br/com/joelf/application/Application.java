package br.com.joelf.application;

import br.com.joelf.domain.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class Application {

    private final BudgetService budgetService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
