package br.com.joelf.domain.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Driver {
    private Long id;
    private String document;
    private LocalDate birthDate;
}
