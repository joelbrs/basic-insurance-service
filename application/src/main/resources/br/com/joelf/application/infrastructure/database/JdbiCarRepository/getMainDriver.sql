select
    id, document, birthdate
from drivers
inner join
    car_drivers on car_drivers.driver_id = drivers.id
where
    car_drivers.car_id = :carId and car_drivers.is_main_driver = true;
