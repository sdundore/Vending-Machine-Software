package com.techelevator;

import java.math.BigDecimal;

public abstract class Items {
 
	private String category;
	private String name;
	private BigDecimal price;
	private String location;
	private Integer qty;

	public Items(String category, String name, BigDecimal price, String location, Integer qty) {

		this.name = name;
		this.price = price;
		this.location = location;
		this.qty = qty;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getLocation() {
		return location;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getCategory() {
		return category;
	}

	public String toString() {
		return String.format("%-8s %-24s %-12s %5.2f %5d", location, name, category, price, qty);
	}
	
	public abstract String getSound();

}
