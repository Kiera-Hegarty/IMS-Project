package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
//		DBUtils.getInstance().init("jdbc:mysql://localhost:3306/ims");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void orderTestCreate() {
		final Order created = new Order(2L,"2020-05-09",1L,25);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void orderTestReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L,"2020-07-08",2L,45));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void orderTestReadLatest() {
		assertEquals(new Order(1L,"2020-07-08",2L,45), DAO.readLatest());
	}
	
	@Test
	public void orderTestRead() {
		final long id = 1L;
		assertEquals(new Order(id,"2020-07-08",2L,45), DAO.read(id));
	}
	
	@Test
	public void orderTestUpdate() {
		final Order updated = new Order(1L,"2020-07-08",2L,45);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void orderTestDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
