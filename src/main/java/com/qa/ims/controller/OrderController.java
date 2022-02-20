package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	
	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	// Reads all orders to the logger

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(orders);
		}
		return orders;
	}
	
	//Creates an order by taking in user input

	@Override
	public Order create() {
		LOGGER.info("Please enter the date when the order was placed");
		String datePlaced = utils.getString();
		LOGGER.info("Please enter the customer id");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter the tottal cost of order");
		int totalCost = utils.getInt();
		Order order = orderDAO.create(new Order(datePlaced, customerID, totalCost));
		LOGGER.info("Order created");
		return order;
	}
	
	// Updates an existing order by taking in user input

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the date when the order was placed");
		String datePlaced = utils.getString();
		LOGGER.info("Please enter the customer id of the order you would like to update");
		Long customerID = utils.getLong();
		LOGGER.info("Please enter the total cost of the updated order");
		int totalCost = utils.getInt();
		Order order = orderDAO.update(new Order(id, datePlaced, customerID, totalCost));
		LOGGER.info("Order updated");
		return order;
	}
	
	// Deletes an existing order by the id of the customer

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}
	
//	private OrderDAO orderDAO;
//	private ItemDAO itemDAO;
//	private Utils utils;
//
//	public OrderController(OrderDAO orderDAO, Utils utils) {
//		super();
//		this.orderDAO = orderDAO; 
//		this.utils = utils;
//	}
//	
//	// Reads all orders to the logger
//
//	@Override
//	public List<Order> readAll() {
//		List<Order> orders = orderDAO.readAll();
//		for (Order order : orders) {
//			LOGGER.info(orders);
//		}
//		return orders;
//	}
//	
//	//Creates an order by taking in user input
//
//	@Override
//	public Order create() {
////		boolean vaild = false;
//		Order order;
////		do {
//			LOGGER.info("Please enter the customer id");
//			Long customerID = utils.getLong();
//			LOGGER.info("Please enter the date order was placed");
//			String datePlaced = utils.getString();
////			LOGGER.info("Please enter the total cost of order");
////			int totalCost  = utils.getInt();
//			order = orderDAO.create(new Order(customerID, datePlaced));
////			if(order != null) {
////				vaild = true;
////			}
////		}while(!vaild);
////		
//		
//		
//		//boolean while loop, so when false statement is given loop will stop
//		
//		boolean od = false;
//		while(true) {
//		do {
//			LOGGER.info("Please enter item id you would like to add to the order");
//			LOGGER.info("Enter n to stop adding items to order");
//			Long itemID = utils.getOrderDetailAction();
//			if(itemID == null) {
//				od = true;
//			}else {
//				LOGGER.info("Enter the total cost of items");
//				int totalCost = utils.getInt();
//				orderDAO.createOrderDetail(order, itemID, totalCost);
//			}
//		}while(!od);
//		
//		LOGGER.info("Order created");
//		}
//	}
//
//	
//	// Updates an existing order by taking in user input
//
//	@Override
//	public Order update() {
//		boolean validOrder = false;
//		Long id;
//		Order order;
//		do {
//			LOGGER.info("Please enter the id of the order you would like to update");
//			id = utils.getLong();
//			order = orderDAO.ReadOrder(id);
//			if(order != null) {
//				validOrder = true;
//			}else {
//				LOGGER.info("Order id does not exist");
//			}
//		}while(!validOrder);
//		
//		LOGGER.info("Please enter order date");
//		String datePlaced = utils.getString();
//		
//		boolean giveOptions = true;
//		do {
//			LOGGER.info("What would you like to update?");
//			LOGGER.info("ADD: add item to order");
//			LOGGER.info("REMOVE: remove item from order");
//			LOGGER.info("RETURN: return to previous section");
//			
//			boolean stop = false;
//			do {
//				String optio = utils.getString().toLowerCase();
//				String options = null;
//				switch(options) {
//				
//				case "add": 
//					boolean validItem = false;
//					do {
//						LOGGER.info("Please enter item id you would like to add to the order");
//						LOGGER.info("Enter n to exit without adding items to order");
//						Long itemID = utils.getOrderDetailAction();
//						if(itemID == null) {
//							stop = true;
//							break;
//						}
//						LOGGER.info("Enter the total cost of items to added into the order");
//						int totalCost = utils.getInt();
//						order = orderDAO.createOrderDetail(order, itemID, totalCost);
//						if(order != null) {
//						LOGGER.info("Item(s) added to order!");
//						validItem = true;
//						stop = true;
//						}
//					}while(!validItem);
//					break;
//				
//				case "remove":
//					boolean removeItem = false;
//					do {
//						LOGGER.info("Please enter item id you would like to remove the order");
//						LOGGER.info("Enter n to exit without removing items from order");
//						Long itemID = utils.getOrderDetailAction();
//						if(itemID == null) {
//							stop = true;
//							break;
//						}
//						LOGGER.info("Enter the price of items added into the order");
//						int price = utils.getInt();
//						order = orderDAO.removeOrderDetail(order, itemID, price);
//						if(order != null) {
//						LOGGER.info("Item(s) removed frm order!");
//						validItem = true;
//						stop = true;
//						}
//					}while(!removeItem);
//					break;
//					
//				case "return":
//					stop = true;
//					giveOptions = false;
//					break;
//				
//				default:
//					LOGGER.info("Try again");
//					break;
//				}
//					
//				}while (!stop);
//				
//			}while(giveOptions);
//			LOGGER.info("Order updated");
//			return order;
//		}
//		
//	
//	// Deletes an existing order by the id of the customer
//
//	@Override
//	public int delete() {
//		LOGGER.info("Please enter the id of the order you would like to delete");
//		Long id = utils.getLong();
//		return orderDAO.delete(id);
//	}

}
