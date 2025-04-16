select exists (
    select (1)
    from customers
    inner join
        drivers on drivers.id = customers.driver_id
    inner join
        claims on claims.driver_id = drivers.id
    where
        customers.id = :customerId
);