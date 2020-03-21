package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Items {

	public Candy(String category, String name, BigDecimal price, String location, Integer qty) {
		super(category, name, price, location, qty);
		
	}

	@Override
	public String getSound() {
		// TODO Auto-generated method stub
		return "Munch Munch, Yum!";
	}
	
}
 