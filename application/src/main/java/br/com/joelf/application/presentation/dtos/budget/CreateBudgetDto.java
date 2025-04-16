package br.com.joelf.application.presentation.dtos.budget;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateBudgetDto(
    @NotNull
    @Positive
    Long customerId,

    @NotNull
    @Positive
    Long carId
) {}
