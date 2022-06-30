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

CREATE TABLE Address (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    street_line varchar(255),
    postal_code int,
    city varchar(255),
    phone_number varchar(255),
    county varchar(255),
    country varchar(255)
);
CREATE TABLE Product (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    description varchar(255),
    price int,
    available_quantity int,
    category int,
    attribute_id int,
    added_date TIMESTAMP
);
CREATE TABLE Category (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255),
    description varchar(255)
);
CREATE TABLE Product_Category (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    category_id  int,
    product_id  int
);
CREATE TABLE Product_Attribute (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255)
);
CREATE TABLE Attribute_Value (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    value varchar(255),
    product_attribute_id int
);
CREATE TABLE Product_Product_Attribute(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id  int,
    product_attribute_id  int,
);
CREATE TABLE Cart_Entry (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id int,
    quantity int,
    price_per_pice int,
    total_price_per_entry int,
    cart_id int
);
CREATE TABLE Cart (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id  int,
    total_price int
);
CREATE TABLE Orders (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id  int,
    cart_id  int
    payment_type int,
    delivery_address_id int,
    billing_address_id int,
    total_price int,
    order_date TIMESTAMP
);


ALTER TABLE User
ADD FOREIGN KEY (default_delivery_address_id) REFERENCES Address(id);
ALTER TABLE User
ADD FOREIGN KEY (default_billing_address_id) REFERENCES Address(id);

ALTER TABLE Cart_Entry
ADD FOREIGN KEY (product_id) REFERENCES Product(id);
ALTER TABLE Cart_Entry
ADD FOREIGN KEY (cart_id) REFERENCES Cart(id);

ALTER TABLE Cart
ADD FOREIGN KEY (user_id) REFERENCES User(id);

ALTER TABLE orders
ADD FOREIGN KEY (billing_address_id) REFERENCES Address(id);
ALTER TABLE orders
ADD FOREIGN KEY (delivery_address_id) REFERENCES Address(id);
ALTER TABLE orders
ADD FOREIGN KEY (delivery_address_id) REFERENCES Address(id);
ALTER TABLE orders
ADD FOREIGN KEY (user_id) REFERENCES User(id);
ALTER TABLE orders
ADD FOREIGN KEY (cart_id) REFERENCES Cart(id);
ALTER TABLE orders
ADD CONSTRAINT UNQ_ST_S_ID UNIQUE (cart_id)

ALTER TABLE Product_Category
ADD FOREIGN KEY (category_id) REFERENCES Category(id);
ALTER TABLE Product_Category
ADD FOREIGN KEY (product_id) REFERENCES Product(id);

ALTER TABLE Attribute_Value
ADD FOREIGN KEY (product_attribute_id) REFERENCES Product_Attribute(id);


ALTER TABLE Product_Product_Attribute
ADD FOREIGN KEY (product_id) REFERENCES Product(id);
ALTER TABLE Product_Product_Attribute
ADD FOREIGN KEY (product_attribute_id) REFERENCES Product_Attribute(id);




