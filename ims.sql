CREATE DATABASE IF NOT EXISTS `ims`;

use `ims`;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

-- DESCRIBE customers;

CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `stock` INT DEFAULT NULL,
    `price` INT DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

--  DESCRIBE items;

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `date_placed` DATE NOT NULL,
    PRIMARY KEY (`order_id`),
	FOREIGN KEY (`customer_id`) REFERENCES `ims`.`customers`(`customer_id`)
);

DESCRIBE orders;

CREATE TABLE IF NOT EXISTS `ims`.`order_details` (
	`order_details_id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_id` INT NOT NULL,
    `order_id` INT NOT NULL,
    `total_cost` INT NOT NULL,
    PRIMARY KEY (`order_details_id`),
    FOREIGN KEY (`item_id`) REFERENCES `ims`.`items`(`item_id`),
    FOREIGN KEY (`order_id`) REFERENCES `ims`.`orders`(`order_id`)
);

 -- DESCRIBE order_details;

-- INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
-- INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('kiera', 'hegarty');
-- SELECT * FROM `ims`.`customers`;

-- INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('Hunger Games', 35, 10);
-- INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('Sherlock Holmes Collection', 20, 25);
-- SELECT * FROM `ims`.`items`;

-- INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (1, '2020-07-08');
-- INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (2, '2021-05-09');
-- SELECT * FROM `ims`.`orders`;

-- INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (1,1,25);
-- INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (2,2,45);
-- SELECT * FROM `ims`.`order_details`;