package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
	List <Items> itemList;

	@SuppressWarnings("resource")
	public List<Items> loadInventory(String fileName) {
		itemList = new ArrayList<>();
		File inventoryList = new File(fileName);
		Scanner itemFeed;
		try {
			itemFeed = new Scanner(inventoryList);
			while (itemFeed.hasNextLine()) {
				String item = itemFeed.nextLine();
				String[] itemArray = item.split("\\|");
				String location = itemArray[0];
				String name = itemArray[1];
				BigDecimal price = new BigDecimal(itemArray[2]);
				String category = itemArray[3];
				switch (category) {
				case "Chip":
					Chips chip = new Chips(category, name, price, location, 5);
					itemList.add(chip);
					break;
				case "Candy":
					Candy candy = new Candy(category, name, price, location, 5);
					itemList.add(candy);
					break;
				case "Gum":
					Gum gum = new Gum(category, name, price, location, 5);
					itemList.add(gum);
					break;
				case "Drink":
					Drink drink = new Drink(category, name, price, location, 5);
					itemList.add(drink);
					break;
				}

			}
			return itemList;
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist");
			e.printStackTrace();
		}

		return null;
	}

}
