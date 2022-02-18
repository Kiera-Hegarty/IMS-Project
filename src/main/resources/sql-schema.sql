drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id `INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `stock` INT DEFAULT NULL,
    `price` INT DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `date_placed` DATE NOT NULL,
    `total_cost` INT NOT NULL,
    PRIMARY KEY (`order_id`),
	FOREIGN KEY (`customer_id`) REFERENCES `customers`(`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_details` (
	`order_details_id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_id` INT NOT NULL,
    `order_id` INT NOT NULL,
    PRIMARY KEY (`order_details_id`),
    FOREIGN KEY (`item_id`) REFERENCES `items`(`item_id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`)
);

