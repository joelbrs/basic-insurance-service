package br.com.joelf.domain.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Insurance {
    private Long id;
    private Long carId;
    private Long customerId;
    private LocalDateTime creationAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
}
