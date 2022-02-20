package com.qa.ims.persistence.domain;

import java.util.ArrayList;

public class Order {
	
	private Long id;
	private Long customerID;
	private String datePlaced;
//	private ArrayList<Item> items;
	private int totalCost;
	
	
	public Order(Long id, String datePlaced, Long customerID, int totalCost) {
		this.setId(id);
		this.setCustomerID(customerID);
		this.setDatePlaced(datePlaced);
		this.setTotalCost(totalCost);
	}
	
//	public Order(Long id, String datePlaced, Long customerID, ArrayList<Item> items, int totalCost) {
//		this.setId(id);
//		this.setCustomerID(customerID);
//		this.setDatePlaced(datePlaced);
//		this.setItems(items);
//		this.setTotalCost(totalCost);
//	}
//	
//	public void Item(Long id, int price) {
//		this.setId(id);
//		this.setPrice(price);
//	}
//	
//
//
//private void setPrice(int price) {
//	this.totalCost = price;
//		
//	}

//	public int cost(){
//		int total = 0;
//		for(Item i : items) {
//			total += i.getValue();
//		}
//		this.totalCost = total;
//		return total;
//	}





	public Order(String datePlaced, Long customerID, int totalCost) {
		this.setCustomerID(customerID);
		this.setDatePlaced(datePlaced);
		this.setTotalCost(totalCost);

	}


	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}
//	
//	public ArrayList<Item> getItems(){
//		return items;
//	}
//	
//	public void setItems(ArrayList<Item> items){
//		this.items = items;
//	}
//	


	
	@Override
	public String toString() {
		return "id:" + id  + " date placed:" + datePlaced +  "customer id:" + customerID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePlaced == null) ? 0 : datePlaced.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());

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
		Order other = (Order) obj;
		if (getDatePlaced() == null) {
			if (other.getDatePlaced() != null)
				return false;
		} else if (!getDatePlaced().equals(other.getDatePlaced()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;

		return true;
	}




}
