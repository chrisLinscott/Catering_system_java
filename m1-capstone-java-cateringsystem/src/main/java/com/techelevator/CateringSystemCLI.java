package com.techelevator;
import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;
import com.techelevator.CateringSystem;
import com.techelevator.items.Customer;


import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.util.Map;

/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CateringSystem class to do any work and pass the results between those 2 classes.
 */
public class CateringSystemCLI {

	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.
	 * It is the only class instantiated in the starter code.
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 *
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */
	private InventoryFileReader inventoryFileReader;
	private Menu menu;
	Map<String, CateringItem> cateringItemMap = null;
	private Customer customer= new Customer();

	public CateringSystemCLI(Menu menu) {
		this.menu = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() {

		menu.showWelcomeMessage();
		//	menu.printStartingMenu();


		//	menu.printStartingMenu();
		inventoryFileReader = new InventoryFileReader("cateringsystem.csv");
		menu.printStartingMenu();
		try {
			cateringItemMap = inventoryFileReader.readFileInventory();
		} catch (FileNotFoundException e){
			menu.fileNotFoundError();}

//		DisplayCateringItems();
//		Order();
//		AddMoney();
//		customer.addMoney(menu.printAddedMoney());
		while (true) {
			String menuOneOutput= menu.menuOutput();
			if (menuOneOutput.equals("1")) {

				menu.PrintCateringItems(cateringItemMap);
			}	else if (menuOneOutput.equals("2")) {
				menu.printSubMenu2();
				break;
			}
			else {
				break;	}
		}

		while (true) {
			String menuTwoOutput= menu.menuOutput();
			if (menuTwoOutput.equals("1")) {
				menu.printAddedMoney();
			//	customer.setCurrentAccountBalance(0);

				customer.addMoney(menu.moneyMenuOutput());
			}	else if (menuTwoOutput.equals("2")) {
				menu.PrintCateringItems(cateringItemMap);

			}
			else {
				break;	}
		}
			/*
			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu
			
			IF the User Choice is Display Catering Items,
				THEN display catering items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/
		//	}
	}

	/*
	 * This starts the application, but you shouldn't need to change it.
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();


		System.out.println();


	}



//	public void Order() {
//		if (menu.printStartingMenu().equals("2")) {
//
//		}
//	}
//	public void AddMoney(){
//		if(menu.printSubMenu2().equals("1")) {
//			menu.printAddedMoney();
//		//	customer.getCurrentAccountBalance()
//
//		}





	}




