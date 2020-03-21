package com.techelevator;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private static final String PURCHASE_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_FEED_MONEY, PURCHASE_SELECT_PRODUCT,
			PURCHASE_FINISH_TRANSACTION };
	private Menu menu;
	private List<Items> itemList = new ArrayList<>();
	private BigDecimal totalAvail = new BigDecimal(0.00);
	Inventory inventory = new Inventory();
	LogFile logFile = new LogFile();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}
 
	public void run() {
		itemList = inventory.loadInventory("vendingmachine.csv");
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.printf("%-8s %-24s %-12s %5s %5s\n", "Slot", "Name", "Type", "Price", "Qty");
				System.out.printf("============================================================\n");
				for (int i = 0; i < itemList.size(); i++) {
					System.out.println(itemList.get(i).toString());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchase();
				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	
	public void purchase() {
		DateFormat time = new SimpleDateFormat("MM/dd/yyyy\thh:mm:ss aa");
		String datetime = time.format(new Date()).toString();
		Scanner input = new Scanner(System.in);
		FeedMoney money = new FeedMoney();
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if (choice.equals(PURCHASE_FEED_MONEY)) {

				System.out.println("Which bill are you prepared to insert? ($1, $2, $5, $10, $20)");
				String feed = input.nextLine();
				if (!feed.equals("1") && !feed.equals("2") && !feed.equals("5") && !feed.equals("10") && !feed.equals("20")) {
					System.out.println("Please enter a valid bill denomination...");
				}
				else {
					totalAvail = money.feedMoney(feed);
				}

			} else if (choice.equals(PURCHASE_SELECT_PRODUCT)) {
				System.out.printf("%-8s %-24s %-12s %5s %5s\n", "Slot", "Name", "Type", "Price", "Qty");
				System.out.printf("============================================================\n");
				for (int i = 0; i < itemList.size(); i++) {
					System.out.println(itemList.get(i).toString());
				}
				System.out.println("");
				System.out.println("Current Money Provided: $" + totalAvail);
				System.out.println("Please choose a selection >>> ");
				String selection = input.nextLine();
				
				for (Items i : itemList) {

					if (selection.equalsIgnoreCase(i.getLocation()) && totalAvail.compareTo(i.getPrice()) >= 0
							&& i.getQty() > 0) {
						totalAvail = totalAvail.subtract(i.getPrice());
						i.setQty(i.getQty()-1);
						System.out.println("Item Purchased: " + i.getName());
						System.out.println("Item Cost: "+ i.getPrice());
						System.out.println(i.getSound());
						System.out.println("");
						System.out.println("Remaining Balance: " + totalAvail);
						String totalAvailFormat = String.format("$%.2f", totalAvail);
						String msg = String.format("\n%-20s\t%-19s %-2s $%-6.2f\tBalance: %-6s", datetime, i.getName(), i.getLocation(), 
								  (totalAvail.add(i.getPrice())), totalAvailFormat);
						logFile.writeToFile(msg);
					}
					else if (selection.equalsIgnoreCase(i.getLocation()) && i.getQty() == 0) {
						System.out.println("Product Sold Out!!");
					}
					else if (selection.equalsIgnoreCase(i.getLocation()) && totalAvail.compareTo(i.getPrice()) < 0) {
						System.out.println("Please insert more money...");
					}
				}

			} else if (choice.equals(PURCHASE_FINISH_TRANSACTION)) {
				GetChange change = new GetChange();
				System.out.println(totalAvail);
				System.out.println(change.getChange(totalAvail));
				totalAvail = totalAvail.subtract(totalAvail);
				break;
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
