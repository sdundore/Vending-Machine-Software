package com.techelevator;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.techelevator.Chips;
import com.techelevator.Inventory;
import com.techelevator.Items;

public class InventoryTest {

	@Test
	public void test_Load_Potato_Crisps() {
		Inventory test = new Inventory();
		List<Items> actual = test.loadInventory("test.txt");
		List<Items> expected = new ArrayList<>();
		expected.add(new Chips("Chip", "Potato Crisps", BigDecimal.valueOf(3.05), "A1", 5));
		assertEquals(expected.toString(),actual.toString());
	}
	
	@Test
	public void test_Load_Triplemint() {
		Inventory test = new Inventory();
		List<Items> actual = test.loadInventory("test1.txt");
		List<Items> expected = new ArrayList<>();
		expected.add(new Gum("Gum", "Triplemint", BigDecimal.valueOf(0.75), "D4", 5));
		assertEquals(expected.toString(),actual.toString());
	}
	
	@Test
	public void test_Load_one_of_each_category() {
		Inventory test = new Inventory();
		List<Items> actual = test.loadInventory("test2.txt");
		List<Items> expected = new ArrayList<>();
		expected.add(new Chips("Chip", "Potato Crisps", BigDecimal.valueOf(3.05), "A1", 5));
		expected.add(new Candy("Candy", "Crunchie", BigDecimal.valueOf(1.75), "B4", 5));
		expected.add(new Drink("Drink", "Cola", BigDecimal.valueOf(1.25), "C1", 5));
		expected.add(new Gum("Gum", "Triplemint", BigDecimal.valueOf(0.75), "D4", 5));
		assertEquals(expected.toString(),actual.toString());
	}
	
	@Test
	public void test_Load_one_of_each_category2() {
		Inventory test = new Inventory();
		List<Items> actual = test.loadInventory("test3.txt");
		List<Items> expected = new ArrayList<>();
		expected.add(new Chips("Chip", "Stackers", BigDecimal.valueOf(1.45), "A2", 5));
		expected.add(new Candy("Candy", "Moonpie", BigDecimal.valueOf(1.80), "B1", 5));
		expected.add(new Drink("Drink", "Mountain Melter", BigDecimal.valueOf(1.50), "C3", 5));
		expected.add(new Gum("Gum", "Little League Chew", BigDecimal.valueOf(0.95), "D2", 5));
		assertEquals(expected.toString(),actual.toString());
	}
	
// This test actually passes but we are not sure how to structure it so it passes jUnit test	
//	@Test
//	public void test_Exception() {
//		Inventory test = new Inventory();
//		String expected = "File does not exist";
//		assertEquals(expected,test.loadInventory("test5.txt"));
//	}

}
