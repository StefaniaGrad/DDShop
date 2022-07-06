CREATE TABLE User (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    phone_number varchar(255),
    password varchar(255),
    default_delivery_address_id int,
    default_billing_address_id int
);