package com.techelevator.view;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.items.Customer;

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
	
	private static final Scanner userInput = new Scanner(System.in);
private Customer customer;
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
	public  void printStartingMenu() {
		System.out.println("Select and option below to proceed");
		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");

	}
	public String menuOutput(){
		return userInput.nextLine();
	}
public void printSubMenu2(){
		System.out.println("Select an option below to proceed");
	System.out.println("(1) Add Money");
	System.out.println("(2) Select Products");
	System.out.println("(3) Complete Transaction");

}
	public Integer moneyMenuOutput() {
		Integer moneyToAddFloat = Integer.parseInt(userInput.nextLine());
		return moneyToAddFloat;
	}
public void printAddedMoney (){
	System.out.println("How much money would you like to add(up to $500.00)?");

}
// redundant because we are printing account balance anyways
// public void showAddedToBalance(float amountAdded){
//	System.out.println("$"+ amountAdded +   " is being added to your balance");
//	//System.out.println("Current Balance = "+ ());
//	// this is supposed to bring us back to our menu options...
//	printSubMenu2();

public void ShowCurrentBalance(float balance){
	System.out.println("Your current balance is $"+ balance );
}
public void ShowCustomerPurchase(){
	System.out.println("Please enter the product code for the item you would like to buy");
}
	public int PurchaseMenuOutput(){
		int userInputInt=Integer.parseInt(userInput.nextLine());
		return userInputInt;
	}
	public void UserEnteredQuantity (){
		System.out.println("Thanks, please enter the quantity");


	}
}


