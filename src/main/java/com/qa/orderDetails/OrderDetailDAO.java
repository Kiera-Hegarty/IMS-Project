package com.qa.orderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class OrderDetailDAO implements Dao<OrderDetail> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public OrderDetail modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_details_id");
	//	Long itemID = resultSet.getLong("item_id");
		ArrayList<Item> items = getItems("item_id");
		Long orderID = resultSet.getLong("order_id");
		int totalCost = resultSet.getInt("total_cost");
		return new OrderDetail(id, items, orderID, totalCost);
	}
	
	@Override
	public OrderDetail modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_details_id");
	//	Long itemID = resultSet.getLong("item_id");
		int price = resultSet.getInt("price");
		Long orderID = resultSet.getLong("order_id");
		int totalCost = resultSet.getInt("total_cost");
		return new OrderDetail(id, price, orderID, totalCost);
	}
	
	// Reads all order details from the database

	@Override
	public List<OrderDetail> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_details");) {
			List<OrderDetail> orderDetails = new ArrayList<>();
			while (resultSet.next()) {
				orderDetails.add(modelFromResultSet(resultSet));
			}
			return orderDetails;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public OrderDetail readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_details ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Creates an order detail in the database

	@Override
	public OrderDetail create(OrderDetail orderDetail) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_details(item_id, order_id, total_cost) VALUES (?, ?, ?)");) {
			statement.setLong(1, orderDetail.getItemID());
			statement.setLong(2, orderDetail.getOrderID());
			statement.setInt(3, orderDetail.getTotalCost());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	@Override
	public OrderDetail read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_details WHERE order_details_id = ?" );) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Updates an order detail in the database

	@Override
	public OrderDetail update(OrderDetail orderDetail) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE order_details SET item_id = ?, order_id = ?, total_cost = ? WHERE order_details_id = ? ");) {
			statement.setLong(1, orderDetail.getItemID());
			statement.setLong(2, orderDetail.getOrderID());
			statement.setInt(3, orderDetail.getTotalCost());
			statement.setLong(4, orderDetail.getId());
			statement.executeUpdate();
			return read(orderDetail.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Deletes an order detail in the database

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_details WHERE order_details_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
