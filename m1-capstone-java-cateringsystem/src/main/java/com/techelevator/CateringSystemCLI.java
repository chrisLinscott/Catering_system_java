package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;
import com.techelevator.CateringSystem;
import com.techelevator.items.Customer;
import com.techelevator.items.ShoppingCart;


import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.util.HashMap;
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

    Map<String, CateringItem> cateringItemMap = null;
    /*
     * The menu class is instantiated in the main() method at the bottom of this file.
     * It is the only class instantiated in the starter code.
     * You will need to instantiate all other classes using the new keyword before you can use them.
     *
     * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
     */
    private InventoryFileReader inventoryFileReader;
    private Menu menu;
    private Customer customer = new Customer();
    private ShoppingCart shoppingCart;

    public CateringSystemCLI(Menu menu) {
        this.menu = menu;
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

    /*
     * Your application starts here
     */
    public void run() {

        menu.showWelcomeMessage();

        inventoryFileReader = new InventoryFileReader("cateringsystem.csv");
        menu.printStartingMenu();
        try {
            cateringItemMap = inventoryFileReader.readFileInventory();
        } catch (FileNotFoundException e) {
            menu.fileNotFoundError();
        }
        while (true) {
            String menuOneOutput = menu.menuOutput();
            if (menuOneOutput.equals("1")) {

                menu.PrintCateringItems(cateringItemMap);
            } else if (menuOneOutput.equals("2")) {
                menu.printSubMenu2();
                break;
            } else {
                break;
            }
        }

        while (true) {
            String menuTwoOutput = menu.menuOutput();

            if (menuTwoOutput.equals("1")) {

                menu.printAddedMoney();
                Float addingToBalance = menu.moneyMenuOutput();
                if (addingToBalance <= 500 && customer.getCurrentAccountBalance() < 1500) {
                    customer.addMoney(addingToBalance);

                    menu.showAddedToBalance(addingToBalance);
                    Float workingBalance = customer.getCurrentAccountBalance();
                    menu.ShowCurrentBalance(workingBalance);

                } else {
                    Float workingBalance = customer.getCurrentAccountBalance();
                    menu.printSubMenu2();
                    menu.ShowCurrentBalance(workingBalance);

                }


            } else if (menuTwoOutput.equals("2")) {
                menu.PrintCateringItems(cateringItemMap);
                menu.ShowCustomerPurchase();
                String itemsProductCode = menu.menuOutput();
                if (cateringItemMap.containsKey(itemsProductCode)) {

                    menu.UserEnteredQuantity();
                }
                int quantityDesired = menu.PurchaseMenuOutput();

                if (cateringItemMap.get(itemsProductCode).getQuantity() >= quantityDesired && customer.getCurrentAccountBalance() >= cateringItemMap.get(itemsProductCode).getPrice() * quantityDesired) {
                    Map<String, Integer> newCart = new HashMap<>();
                    newCart.put(itemsProductCode, quantityDesired);

                    // shoppingCart=new ShoppingCart()
                    //
                    //  if(quantityDesired* cateringItemMap.get(menu.menuOutput())<= customer.getCurrentAccountBalance() )

                }
            } else {
                break;
            }
        }
			/*
			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu

			IF the User Choice is Display Catering Items,
				THEN display catering items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/

    }


}




