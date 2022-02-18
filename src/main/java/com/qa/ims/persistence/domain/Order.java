package com.qa.ims.persistence.domain;

public class Order {
	
	private Long id;
	private Long customerID;
	private String datePlaced;
	
	public Order(String datePlaced, Long customerID) {
		this.setCustomerID(customerID);
		this.setDatePlaced(datePlaced);
	}
	
	public Order(Long id, String datePlaced, Long customerID) {
		this.setId(id);
		this.setCustomerID(customerID);
		this.setDatePlaced(datePlaced);
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
	//	result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());

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
//		if (customerID == null) {
//			if (other.customerID != null)
//				return false;
//		} else if (!customerID.equals(other.customerID))
//			return false;

		return true;
	}

}
