CREATE TABLE drivers (
    id SERIAL PRIMARY KEY,
    document VARCHAR(20) UNIQUE NOT NULL,
    birthdate DATE NOT NULL
);

CREATE TABLE customers (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   driver_id INT NOT NULL,
   CONSTRAINT fk_driver_customer FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    model VARCHAR(100) NOT NULL,
    manufacturer VARCHAR(100) NOT NULL,
    years INT NOT NULL,
    fipe_value DECIMAL(12,4) NOT NULL
);


CREATE TABLE budgets (
    id SERIAL PRIMARY KEY,
    based_fipe_value DECIMAL(12,4) NOT NULL,
    standard_aliquot DECIMAL(12, 4) NOT NULL,
    risk_management_additional DECIMAL(12,4) NOT NULL
);

CREATE TABLE insurances (
    id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL,
    creation_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    car_id INT NOT NULL,
    is_active BOOLEAN DEFAULT TRUE,
    budget_id INT NOT NULL,
    CONSTRAINT fk_customer_insurance FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT fk_car_insurance FOREIGN KEY (car_id) REFERENCES cars(id),
    CONSTRAINT fk_budget_insurance FOREIGN KEY (budget_id) REFERENCES budgets(id)
);

CREATE TABLE claims (
    id SERIAL PRIMARY KEY,
    car_id INT NOT NULL,
    driver_id INT NOT NULL,
    event_date DATE NOT NULL,
    CONSTRAINT fk_car_claim FOREIGN KEY (car_id) REFERENCES cars(id),
    CONSTRAINT fk_driver_claim FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

CREATE TABLE car_drivers (
     car_id INT NOT NULL,
     driver_id INT NOT NULL,
     is_main_driver BOOLEAN DEFAULT FALSE,
     PRIMARY KEY (car_id, driver_id),
     CONSTRAINT fk_car_car_drivers FOREIGN KEY (car_id) REFERENCES cars(id),
     CONSTRAINT fk_driver_car_drivers FOREIGN KEY (driver_id) REFERENCES drivers(id)
);
