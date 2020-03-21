package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class GetChangeTest {

		GetChange change = new GetChange();
		
	@Test
	public void test_for_$1_00_change() {
		BigDecimal test = new BigDecimal(1.00);
		String expected = "Your change is 4 quarters.";
		assertEquals(expected, change.getChange(test));
	}
	
	@Test
	public void test_for_$3_00_change() {
		BigDecimal test = new BigDecimal(3.00);
		String expected = "Your change is 12 quarters.";
		assertEquals(expected, change.getChange(test));
	}
	
	@Test
	public void test_for_$2_45_change() {
		BigDecimal test = new BigDecimal(2.45);
		String expected = "Your change is 9 quarters and 2 dimes.";
		String actual = change.getChange(test);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_for_$1_35_change() {
		BigDecimal test = new BigDecimal(1.35);
		String expected = "Your change is 5 quarters and 1 dime.";
		String actual = change.getChange(test);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_for_$1_05_change() {
		BigDecimal test = new BigDecimal(1.05);
		String expected = "Your change is 4 quarters and 1 nickel.";
		String actual = change.getChange(test);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_for_$2_40_change() {
		BigDecimal test = new BigDecimal(2.40);
		String expected = "Your change is 9 quarters, 1 dime, and 1 nickel.";
		String actual = change.getChange(test);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_for_$1_45_change() {
		BigDecimal test = new BigDecimal(1.45);
		String expected = "Your change is 5 quarters and 2 dimes.";
		String actual = change.getChange(test);
		assertEquals(expected, actual);
	}

}
