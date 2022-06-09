package com.techelevator.view;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the catering system.
 */
public class Menu {
	
	private static final Scanner in = new Scanner(System.in);

	public void showWelcomeMessage() {
		System.out.println("*************************");
		System.out.println("**     Weyland Corp.   **");
		System.out.println("**      Catering       **");
		System.out.println("*************************");
		System.out.println();
	}

	public void PrintCateringItems (Map<String, CateringItem> showUser){
		System.out.println("Catering Menu is Listed Below");
		System.out.println();
		System.out.println("Product Code      Item Name      Quantity Available     Price"   );
		for ( Map.Entry<String, CateringItem> mapEntry : showUser.entrySet()) {
			System.out.print("    "+ mapEntry.getValue().getProductCode()+ "       ");
			System.out.print("    " +mapEntry.getValue().getItemName()+"           " );
			System.out.print(mapEntry.getValue().getQuantity()+ " " );
			System.out.println("$" +mapEntry.getValue().getPrice());
		}
		System.out.println();
	}

	public  void fileNotFoundError(){
		System.out.println("File not found");
	}
	public  String printStartingMenu() {
		System.out.println("Select and option below to proceed");
		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");
		Scanner scanner=new Scanner(System.in);
		String userInput= scanner.nextLine();
		return userInput;
	}

public String printSubMenu2(){
	System.out.println("Select and option below to proceed");
	System.out.println("(1) Add Money");
	System.out.println("(2) Select Products");
	System.out.println("(3) Complete Transaction");
	Scanner scanner=new Scanner(System.in);
	String userInput= scanner.nextLine();
	return userInput;
}
public void printAddedMoney (){
	System.out.println("How much money would you like to add?");
	Scanner moneyScanner = new Scanner(System.in);
	String moneyToAdd = moneyScanner.nextLine();
	Float moneyToAddFloat = Float.parseFloat(moneyToAdd);

	System.out.println("$"+ moneyToAddFloat + " is being added to your balance");

		// this is supposed to bring us back to our menu options...
	printSubMenu2();

}
}


