package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String itemName;
	private int stock;
	private int price;
	
	public Item(String itemName, int stock, int price) {
		this.setItemName(itemName);
		this.setStock(stock);
		this.setPrice(price);
	}
	
	public Item(Long id, String itemName, int stock, int price) {
		this.setId(id);
		this.setItemName(itemName);
		this.setStock(stock);
		this.setPrice(price);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "id:" + id + " item name:" + itemName + " amount of stock:" + stock + "price of item:" + price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((stock == 0) ? 0 : stock.hashCode());
//		result = prime * result + ((price == 0) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (stock == 0) {
//			if (other.stock != 0)
//				return false;
//		} else if (!stock.equals(other.stock))
//			return false;
//		if (price == 0) {
//			if (other.stock != 0) 
//				return false;
//		}else if (!price.equals(other.price))
//		return true;
//	}
		return true;
	}

		}


