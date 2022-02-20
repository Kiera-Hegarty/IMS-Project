package com.qa.orderDetails;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.CrudController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.utils.Utils;

public class OrderDetailController implements CrudController<OrderDetail> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDetailDAO orderDetailDAO;
	private Utils utils;

	public OrderDetailController(OrderDetailDAO orderDetailDAO,  Utils utils) {
		super();
		this.orderDetailDAO = orderDetailDAO;
		this.utils = utils;
	}
	
	// Reads all order details to the logger

	@Override
	public List<OrderDetail> readAll() {
		List<OrderDetail> orderDetails = orderDetailDAO.readAll();
		for (OrderDetail orderDetail : orderDetails) {
		 LOGGER.info(orderDetail);
		}
		return orderDetails;
	}
		
	// Creates an order detail by taking in user input
	// loop will add items till false statement is given

	@Override
	public OrderDetail create() {
		LOGGER.info("Please enter item id");
		Long itemID = utils.getLong();
		
		

		
		//LOGGER.info("Would you like to add another item id"),
		//Long itemID = utils.getLong();
		LOGGER.info("Please enter order id");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter total cost");
		int totalCost = utils.getInt();
		OrderDetail orderDetail = orderDetailDAO.create(new OrderDetail(itemID, orderID, totalCost));
		LOGGER.info("Order detail created");
		return orderDetail;
	}
	
	// Updates an existing order detail by taking in user input

	@Override
	public OrderDetail update() {
		LOGGER.info("Please enter the order detail id you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter item id");
		Long itemID = utils.getLong();
		LOGGER.info("Please enter order id");
		Long orderID = utils.getLong();
		LOGGER.info("Please enter total cost");
		int totalCost = utils.getInt();
		OrderDetail orderDetail = orderDetailDAO.update(new OrderDetail(id, itemID, orderID, totalCost));
		LOGGER.info("Order detail updated");
		return orderDetail;
	}
	
	// Deletes an existing oder id by the id of the order detail

	@Override
	public int delete() {
		LOGGER.info("Please enter the order detail id you would like to delete");
		Long id = utils.getLong();
		return orderDetailDAO.delete(id);
	}


}
