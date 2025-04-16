package br.com.joelf.domain.port;

public interface ClaimRepository {
    boolean driverHasClaimByCustomerId(Long customerId);
    boolean carHasClaim(Long carId);
}
