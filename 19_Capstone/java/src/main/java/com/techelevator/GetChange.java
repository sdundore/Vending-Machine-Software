package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetChange {
	
	private LogFile logFile = new LogFile();
	
	public String getChange(BigDecimal totAvail) {

		DateFormat time = new SimpleDateFormat("MM/dd/yyyy\thh:mm:ss aa");
		String datetime = time.format(new Date()).toString();

		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		double prevTot = totAvail.doubleValue();
		double totalAvail = totAvail.multiply(new BigDecimal(100.00)).doubleValue();
		int totalInt = (int)totalAvail;
		String prevTotFormat = String.format("$%.2f", prevTot);
		int twentyFives = 25;
		int tens = 10;
		int fives = 05;

		while (totalInt >= 25) {
			totalInt = totalInt - twentyFives;
			quarters += 1;

		}
		while (totalInt >= 10) {
			totalInt = totalInt - tens;
			dimes += 1;

		}
		while (totalInt >= 5) { 
			totalInt = totalInt - fives;
			nickels += 1;
		}
		String totalAvailFormat = "$0.00";

//		String fileName = "log.txt";
//		File file = new File(fileName);
//		PrintWriter writer = null;
//		try {
//			writer = new PrintWriter(new FileOutputStream(file, true));
//		} catch (FileNotFoundException e) {
//			System.out.println("File cannot be written to");
//			e.printStackTrace();
//			System.exit(0);
//		}
		logFile.writeToFile("\n" + datetime + "\tGIVE CHANGE: " + prevTotFormat + "\t\tBalance: " + totalAvailFormat);
		
		String change = "";
		
		
//		change = "Your change is " + Integer.toString(quarters) + " quarters, " + Integer.toString(dimes)
//				+ " dimes, and " + Integer.toString(nickels) + " nickel.";
		
		
		if (dimes == 0 && nickels == 0) {
			change = "Your change is " + Integer.toString(quarters) + " quarters.";
			}
		else if (dimes == 0 && nickels == 1) {
			change = "Your change is " + Integer.toString(quarters) + " quarters and " + Integer.toString(nickels) + " nickel.";;
			}
		else if (dimes == 1 && nickels == 1) {
			change = "Your change is " + Integer.toString(quarters) + " quarters, " + Integer.toString(dimes)
				+ " dime, and " + Integer.toString(nickels) + " nickel.";
		}
		else if (dimes == 1 && nickels == 0) {
			change = "Your change is " + Integer.toString(quarters) + " quarters and " + Integer.toString(dimes)
					+ " dime.";
			}
		else if (dimes == 2 && nickels == 1) {
			change = "Your change is " + Integer.toString(quarters) + " quarters, " + Integer.toString(dimes)
				+ " dimes, and " + Integer.toString(nickels) + " nickel.";
		}
		else if (dimes == 2 && nickels == 0) {
			change = "Your change is " + Integer.toString(quarters) + " quarters and " + Integer.toString(dimes)
					+ " dimes.";
			}

		return change;

	}

}
