package com.qa.ims.persistence.dao;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO =  new ItemDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
//		DBUtils.getInstance().init("jdbc:mysql://localhost:3306/ims");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	
	@Test
	public void itemTestCreate() {
		final Item created = new Item(2L,"Sherlock Holmes Collection", 20, 25);
		assertEquals(created, DAO.create(created));
		
	}
	
	@Test
	public void itemTestReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L,"Hunger Games", 35, 10));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void itemTestReadLatest() {
		assertEquals(new Item(1L,"Hunger Games", 35, 10), DAO.readLastest());
	}
	
	@Test
	public void itemTestRead() {
		final long id = 1L;
		assertEquals(new Item(id,"Hunger Games", 35, 10), DAO.read(id));
	}
	
	@Test
	public void itemTestUpdate() {
		final Item updated = new Item(1L,"Hunger Games", 35, 10);
		assertEquals(updated, DAO.update(updated));
	}
	
	@Test
	public void itemTestDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
