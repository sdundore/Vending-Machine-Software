package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FeedMoneyTest {

		FeedMoney addMoney = new FeedMoney();
		
	@Test
	public void test_Load_5() {
		BigDecimal actual = addMoney.feedMoney("5");
		BigDecimal expected = new BigDecimal(5.00);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_Load_two_5s() {
		BigDecimal actual = addMoney.feedMoney("5");
		actual = addMoney.feedMoney("5");
		BigDecimal expected = new BigDecimal(10.00);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_Load_3_1s() {
		BigDecimal actual = addMoney.feedMoney("1");
		actual = addMoney.feedMoney("1");
		actual = addMoney.feedMoney("1");
		BigDecimal expected = new BigDecimal(3.00);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_Load_one_of_each_1_2_5() {
		BigDecimal actual = addMoney.feedMoney("1");
		actual = addMoney.feedMoney("2");
		actual = addMoney.feedMoney("5");
		BigDecimal expected = new BigDecimal(8.00);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_Load_one_of_each_1_2_5_10() {
		BigDecimal actual = addMoney.feedMoney("1");
		actual = addMoney.feedMoney("2");
		actual = addMoney.feedMoney("5");
		actual = addMoney.feedMoney("10");
		BigDecimal expected = new BigDecimal(18.00);
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_Load_one_of_each_bill() {
		BigDecimal actual = addMoney.feedMoney("1");
		actual = addMoney.feedMoney("2");
		actual = addMoney.feedMoney("5");
		actual = addMoney.feedMoney("10");
		actual = addMoney.feedMoney("20");
		BigDecimal expected = new BigDecimal(38.00);
		assertEquals(expected, actual);
	}
	

}
