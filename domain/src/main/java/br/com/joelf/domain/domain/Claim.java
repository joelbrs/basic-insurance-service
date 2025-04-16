package br.com.joelf.domain.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Claim {
    private Long id;
    private Long carId;
    private Long driverId;
    private LocalDate eventDate;
}
