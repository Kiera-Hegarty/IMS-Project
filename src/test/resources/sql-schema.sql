DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `ism`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE IF NOT EXISTS `ims`.`items` (
	`item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `stock` INT DEFAULT NULL,
    `price` INT DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

-- DESCRIBE items;

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
	`order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT DEFAULT NULL,
    `date_placed` DATE DEFAULT NULL,
    `total_cost` INT DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    CONSTRAINT `FK_customerId_1` FOREIGN KEY (`customer_id`) REFERENCES `customers`(`id`) ON DELETE CASCADE
);

-- DESCRIBE orders;

CREATE TABLE IF NOT EXISTS `ims`.`order_details` (
	`order_details_id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_id` INT DEFAULT NULL,
    `order_id` INT DEFAULT NULL,
    PRIMARY KEY (`order_details_id`),
    FOREIGN KEY (`item_id`) REFERENCES `ims`.`items`(`item_id`),
    FOREIGN KEY (`order_id`) REFERENCES `ims`.`orders`(`order_id`),
    CONSTRAINT `FK_itemId_1` FOREIGN KEY (`item_id`) REFERENCES `items`(`id`) ON DELETE CASCADE,
    CONSTRAINT `FK_orderId_1` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`) ON DELETE CASCADE
);