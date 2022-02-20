package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order>{
	
	public static final Logger LOGGER = LogManager.getLogger();

		@Override
		public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_id");
		String datePlaced = resultSet.getString("date_placed");
		Long customerID = resultSet.getLong("customer_id");
//		ArrayList<Item> items = getItems(id);
		int totalCost = resultSet.getInt("total_cost");
		return new Order(id, datePlaced, customerID, totalCost);
	}
	
//	@Override
//	public Item modelFromResultSetItem(ResultSet resultSet) throws SQLException {
//		Long id = resultSet.getLong("item_id");
//		String itemName = resultSet.getString("item_name");
//		int stock = resultSet.getInt("stock");
//		int price = resultSet.getInt("price");
//		return new Item(id, itemName, stock, price);
//	}

	// Adding ArrayList<Item>  
	
//	public ArrayList<Item> getItems(Long id){
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT FROM orders INNER JOIN items ON order_details.item_id = item_id");){
//			ArrayList<Item> items = new ArrayList<>();
//			while(resultSet.next()) {
//				items.add(modelFromResultSetItem(resultSet));
//			}
//			return items;
//		}catch (SQLException e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return new ArrayList<>(); 
//	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Creates an order in the database
	
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(date_placed, customer_id, total_cost) VALUES (?, ?, ?)");) {
			statement.setString(1, order.getDatePlaced());
			statement.setLong(2, order.getCustomerID());
			statement.setInt(3, order.getTotalCost());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}
	
	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
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
	
	// [create] adds items to the order
//	
//	public Order createOrderDetail(Order order, long itemID, int price) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection
//						.prepareStatement("INSERT FROM order(order_id, item_id, price) VALUES (?, ?, ?)");) {
//		    statement.setLong(1, order.getId());
//		    statement.setLong(2 order.getItemID());
//			statement.setInt(3, order.getprice());
//			statement.executeUpdate();
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
		
	// remove items from order
	
//	public Order removeOrderDetail(Order order, long itemID, int price) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection
//						.prepareStatement("DELETE FROM order_details(order_id, item_id, price) VALUES (?, ?, ?)");) {
//			statement.setLong(1, order.getId());
//			statement.setLong(2, order.getID());
//			statement.setInt(3, order.getprice());
//			statement.executeUpdate();
//			return readLatest();
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
	
	// Updates an order in the database
	
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
					.prepareStatement("UPDATE orders SET date_placed = ?, customer_id = ?, total_cost = ?, WHERE order_id = ?");) {
			statement.setString(1, order.getDatePlaced());
			statement.setLong(2, order.getCustomerID());
			statement.setInt(3, order.getTotalCost());
			statement.setLong(4, order.getId());
			statement.executeUpdate();
			return read(order.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Deletes an order in the database

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public Order ReadOrder(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
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






}
