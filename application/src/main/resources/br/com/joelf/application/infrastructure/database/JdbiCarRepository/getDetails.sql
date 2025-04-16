select
    id, model, manufacturer, years, fipe_value
from cars
where
    cars.id = :carId;