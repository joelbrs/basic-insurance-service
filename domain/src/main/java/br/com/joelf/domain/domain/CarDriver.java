package br.com.joelf.domain.domain;

import lombok.Data;

@Data
public class CarDriver {
    private Long id;
    private Long carId;
    private Long driverId;
    private boolean isMainDriver;
}
