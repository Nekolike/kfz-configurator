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

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE saved_kfz_configurations (
    saved_kfz_configuration_id SERIAL PRIMARY KEY,
    car_class_id INT REFERENCES car_classes (car_class_id),
    car_type_id INT REFERENCES car_types (car_type_id),
    color_id INT REFERENCES colors (color_id),
    engine_power_id INT REFERENCES engine_power (engine_power_id),
    optional_equipment_id INT REFERENCES optional_equipment (optional_equipment_id),
    user_id INT REFERENCES users (user_id)
);
