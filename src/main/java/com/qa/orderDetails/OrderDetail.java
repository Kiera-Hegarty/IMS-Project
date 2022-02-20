package com.qa.orderDetails;

import java.util.ArrayList;

import com.qa.ims.persistence.domain.Item;

public class OrderDetail {
	
	private Long id;
	ArrayList<Item> items;
//	private Long itemID;
	private Long orderID;
	private int totalCost;
	
	public OrderDetail(Long itemID, Long orderID, int totalCost) {
		this.setItems(items);
		//	this.setItemID(itemID);
		this.setOrderID(orderID);
		this.setTotalCost(totalCost);
	}
	
	public OrderDetail(Long id, Long itemID, Long orderID, int totalCost) {
		this.setId(id);
		this.setItems(items);
		this.setOrderID(orderID);
		this.setTotalCost(totalCost);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Item> getItemID() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	
	// method for calculating total cost
	
	public int cost() {
		int total = 0;
		for(Item i : items) {
			total += i.getValue();
		}
		this.totalCost = total;
		return total;
	}
	
	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = price;
	}

	
	@Override
	public String toString() {
		return "id:" + id + " item id" + items + " order id" + orderID + "total cost" + totalCost;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
	//	result = prime * result + ((totalCost == 0) ? 0 : totalCost.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
//		if (items == null) {
//			if (other.getItemID() != null)
//				return false;
//		} else if (!items.equals(other.getItemID()))
//			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
//		if (totalCost == 0) {
//			if (other.totalCost != 0)
//				return false;
//		} else if (!totalCost.equals(other.totalCost))
//			return false;
		return true;
	}


}
