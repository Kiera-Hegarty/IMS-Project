INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('kiera', 'hegarty');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('seonaid', 'walker');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('neal', 'mcculloch');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('kristina', 'krieger');
SELECT * FROM `ims`.`customers`;

INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('Hunger Games', 35, 10);
INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('Sherlock Holmes Collection', 20, 25);
INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('Of Mice and Men', 50, 13);
INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('The Great Gatsby', 32, 11);
INSERT INTO  `ims`.`items` (`item_name`, `stock`, `price`) VALUES ('The Giver', 25, 10);
SELECT * FROM `ims`.`items`;

INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (2, '2020-07-08',45);
INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (1, '2020-05-09',25);
INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (5, '2020-12-12',31);
INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (4, '2021-06-11',14);
INSERT INTO `ims`.`orders` (`customer_id`, `date_placed`, `total_cost`) VALUES (3, '2021-10-04',54);
SELECT * FROM `ims`.`orders`;

INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (3,5);
INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (5,4);
INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (1,3);
INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (4,2);
INSERT INTO `ims`.`order_details` ( `item_id`, `order_id`) VALUES (2,1);
SELECT * FROM `ims`.`order_details`;
