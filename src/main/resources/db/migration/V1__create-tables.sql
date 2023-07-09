CREATE TABLE car_classes (
    id SERIAL PRIMARY KEY,
    car_class VARCHAR(255),
    price INTEGER
);

CREATE TABLE car_types (
    id SERIAL PRIMARY KEY,
    car_type VARCHAR(100),
    price INTEGER
);

CREATE TABLE colors (
    id SERIAL PRIMARY KEY,
    color VARCHAR(100),
    price INTEGER
);

CREATE TABLE engine_power (
    id SERIAL PRIMARY KEY,
    kw INTEGER,
    price INTEGER
);

CREATE TABLE optional_equipment (
    id SERIAL PRIMARY KEY,
    equipment VARCHAR(100),
    price INTEGER
);
