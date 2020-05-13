--The FOREIGN KEY constraint is used to prevent actions that would destroy links between tables
--The FOREIGN KEY constraint also prevents invalid data from being inserted into the foreign key column,
--because it has to be one of the values contained in the table it points to
--TODO: algorithm for saving password

--on update cascade????? what is that?????

--show databases;

USE coffeeshop;

--BACKUP DATABASE coffeeshop
--TO DISK = 'C:/backups/coffeeshop.bak' ??
--WITH DIFFERENTIAL;

--TABLES
------------------------------------------------------------------------------------------------------------------------
--user
CREATE TABLE IF NOT EXISTS user (
id INTEGER NOT NULL AUTO_INCREMENT,
login VARCHAR(30) NOT NULL UNIQUE,
password VARCHAR(64) NOT NULL UNIQUE,
name VARCHAR(50) NOT NULL,
surname VARCHAR(50) NOT NULL,
phone VARCHAR(50) NOT NULL UNIQUE,
role TINYINT NOT NULL,
CONSTRAINT pk_user PRIMARY KEY(id)
);
------------------------------------------------------------------------------------------------------------------------
--address
CREATE TABLE IF NOT EXISTS address(
id INTEGER NOT NULL AUTO_INCREMENT,
city VARCHAR(50) NOT NULL,
street VARCHAR(50) NOT NULL,
house INTEGER NOT NULL,
flat INTEGER,
user_id INTEGER NOT NULL,
CONSTRAINT pk_address PRIMARY KEY(id),
CONSTRAINT fk_address_user FOREIGN KEY (user_id)
REFERENCES user(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);
------------------------------------------------------------------------------------------------------------------------
--menu_item
CREATE TABLE IF NOT EXISTS menu_item(
id INTEGER NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
weight DECIMAL NOT NULL,
cost DECIMAL NOT NULL,
ingredient_id INTEGER NOT NULL,
CONSTRAINT pk_menu_item PRIMARY KEY(id),
CONSTRAINT fk_menu_item_ingredient FOREIGN KEY (ingredient_id)
REFERENCES ingredient(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);
------------------------------------------------------------------------------------------------------------------------
--ingredient
CREATE TABLE IF NOT EXISTS ingredient(
id INTEGER NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
CONSTRAINT pk_ingredient PRIMARY KEY(id)
);
------------------------------------------------------------------------------------------------------------------------
--order
CREATE TABLE IF NOT EXISTS order_item(
id INTEGER NOT NULL AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
price DECIMAL NOT NULL,
menu_item_id INTEGER NOT NULL,
CONSTRAINT pk_order PRIMARY KEY(id),
CONSTRAINT fk_order_menu_item FOREIGN KEY (menu_item_id)
REFERENCES menu_item(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);
------------------------------------------------------------------------------------------------------------------------
--order_info
CREATE TABLE IF NOT EXISTS order_info(
id INTEGER NOT NULL AUTO_INCREMENT,
date DATE NOT NULL,
user_id INTEGER NOT NULL,
address_id INTEGER NOT NULL,
order_item_id INTEGER NOT NULL,
CONSTRAINT pk_order_info PRIMARY KEY(id),
CONSTRAINT fk_order_info_user FOREIGN KEY (user_id)
REFERENCES user(id)
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT fk_order_info_address FOREIGN KEY (address_id)
REFERENCES address(id)
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT fk_order_info_order_item FOREIGN KEY (order_item_id)
REFERENCES order_item(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);









