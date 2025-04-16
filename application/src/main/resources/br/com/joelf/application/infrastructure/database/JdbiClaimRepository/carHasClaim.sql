select exists (
    select (1)
    from cars
    inner join
        claims on claims.car_id = cars.id
    where
        cars.id = :carId
);