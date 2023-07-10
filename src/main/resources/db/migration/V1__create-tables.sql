CREATE TABLE car_classes (
    car_class_id SERIAL PRIMARY KEY,
    car_class VARCHAR(255),
    price INTEGER
);

CREATE TABLE car_types (
    car_type_id SERIAL PRIMARY KEY,
    car_type VARCHAR(100),
    price INTEGER
);

CREATE TABLE colors (
    color_id SERIAL PRIMARY KEY,
    color VARCHAR(100),
    price INTEGER
);

CREATE TABLE engine_power (
    engine_power_id SERIAL PRIMARY KEY,
    kw INTEGER,
    price INTEGER
);

CREATE TABLE optional_equipment (
    optional_equipment_id SERIAL PRIMARY KEY,
    equipment VARCHAR(100),
    price INTEGER
);
