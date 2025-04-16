package br.com.joelf.domain.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Driver {
    private Long id;
    private String document;
    private LocalDate birthDate;
}
