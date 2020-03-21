package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Items {

	public Drink(String category, String name, BigDecimal price, String location, Integer qty) {
		super(category, name, price, location, qty);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return "Glug Glug, Yum!";
	}

}
 