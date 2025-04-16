
insert into drivers (document, birthdate) values
('12345678900', '1999-04-15'),
('98765432100', '2000-08-20'),
('11122233344', '1995-01-10'),
('55566677788', '2004-06-12');

insert into customers (name, driver_id) values
('João Silva', 1),
('Maria Oliveira', 2),
('Carlos Souza', 3),
('Laura Martins', 4);

insert into cars (model, manufacturer, years, fipe_value) values
('Civic', 'Honda', 2020, 85000.00),
('Corolla', 'Toyota', 2019, 79000.00),
('Onix', 'Chevrolet', 2021, 60000.00),
('HB20', 'Hyundai', 2022, 72000.00);

-- insert into insurances (customer_id, creation_dt, updated_at, car_id, is_active) values
-- (1, '2024-01-10 10:00:00', '2024-01-15 14:30:00', 1, true),
-- (2, '2024-02-01 09:20:00', NULL, 2, false),
-- (3, '2024-03-05 12:00:00', '2024-03-10 13:00:00', 3, true),
-- (4, '2024-04-01 09:00:00', NULL, 4, true);

insert into claims (car_id, driver_id, event_date) values
(1, 1, '2023-05-10'),
(2, 2, '2022-12-01');

insert into car_drivers (car_id, driver_id, is_main_driver) values
(1, 1, true),
(2, 2, true),
(3, 3, true),
(3, 1, false),
(4, 4, true);