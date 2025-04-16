package br.com.joelf.domain.port;

public interface ClaimRepository {
    boolean driverHasClaim(String document);
    boolean carHasClaim(Long carId);
}
