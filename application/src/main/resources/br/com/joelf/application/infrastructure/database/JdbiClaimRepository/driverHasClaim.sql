select exists (
    select (1)
    from drivers
    inner join
        claims on claims.driver_id = drivers.id
    where
        drivers.document = :document
);