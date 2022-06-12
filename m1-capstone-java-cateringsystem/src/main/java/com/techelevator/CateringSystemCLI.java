package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.HashMap;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;

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

    private Menu menu;
    private CateringSystem cateringSystem;
    private InventoryFileReader inventoryFileReader;


    public CateringSystemCLI(Menu menu) {

        this.menu = menu;

    }

    /*
     * This starts the application, but you shouldn't need to change it. // main method calls run method, dont change.
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
//run method very short, only runs program, will use another method to run sub-menus, that is called via run.
        menu.showWelcomeMessage();
        menu.printStartingMenu();

        inventoryFileReader = new InventoryFileReader("cateringsystem.csv");
        try {
        cateringSystem = new CateringSystem(inventoryFileReader.readFileInventory());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (true) {
            String menuOneOutput = menu.menuOutput();
            // next two lines are ok, cant make more concise
            if (menuOneOutput.equals("1")) {
                menu.PrintCateringItems(cateringSystem.getCateringItemMap());
                menu.printStartingMenu();
            } else if (menuOneOutput.equals("2")) {
                //instead of our previous break, go to next method
                runSubMenuTwo();
            } else { //this closes the program and should go to exit code , make menu method to display closing message.
                menu.singleLineMessages("Goodbye");
                break;
            }
        }

    }

    private void runSubMenuTwo() {

        //print sub-menu before loop

        menu.printSubMenu2();

        String menuTwoOutput = menu.menuOutput();
        //remove the customer class to simplify , pulling info just from cateringSystem to CLI?

        if (menuTwoOutput.equals("1")) {

            menu.printAddedMoney();

            Integer addingToBalance = menu.moneyMenuOutput();
            cateringSystem.addMoney(addingToBalance);

            // redundant menu.showAddedToBalance(addingToBalance);
            Float workingBalance = cateringSystem.getCurrentAccountBalance();
            menu.ShowCurrentBalance(workingBalance);
            runSubMenuTwo();
        }
//shopping cart---- this is really long...
        if (menuTwoOutput.equals("2")) {

            menu.PrintCateringItems(cateringSystem.getCateringItemMap());
            menu.ShowCustomerPurchase();
            String itemsProductCode = menu.menuOutput();

            menu.UserEnteredQuantity();
            int quantityDesired = menu.PurchaseMenuOutput();
            if (!(cateringSystem.getCateringItemMap().containsKey(itemsProductCode))) {
                menu.singleLineMessages("Sorry, product does not exist");
                runSubMenuTwo();
            }
            if (cateringSystem.getQuantity(itemsProductCode) < quantityDesired) {
                menu.singleLineMessages("Sorry, there is not enough product in stock");
                runSubMenuTwo();
            } //dont really need this next if statement but we will keep it anyways
            if (!(cateringSystem.getCurrentAccountBalance() >= cateringSystem.getCateringItemMap().get(itemsProductCode).getPrice())) {
                menu.singleLineMessages("Sorry, you don't have enough money for this");
                runSubMenuTwo();
            }
            if (cateringSystem.getCateringItemMap().get(itemsProductCode).getQuantity() == 0) {
                menu.singleLineMessages("Product out of stock!");
                runSubMenuTwo();
            }
            if (cateringSystem.getCateringItemMap().containsKey(itemsProductCode) && cateringSystem.getQuantity(itemsProductCode) >= quantityDesired && cateringSystem.getCurrentAccountBalance() >= cateringSystem.getCateringItemMap().get(itemsProductCode).getPrice()) {
                cateringSystem.addToCart(itemsProductCode, quantityDesired);


                menu.ShowCurrentBalance(cateringSystem.updatingBalanceAfterShopping(cateringSystem.getCateringItemMap().get(itemsProductCode).getPrice(), quantityDesired));
                runSubMenuTwo();

            }

        } if (menuTwoOutput.equals("3"))
        {
            menu.singleLineMessages("Thank you for shopping, your receipt and change is below.");

            menu.displayChange(cateringSystem.makeChange(cateringSystem.getCurrentAccountBalance()));
            menu.printReceipt(cateringSystem.getShoppingCart());

            cateringSystem.resetBalance();
            System.out.println();
            menu.printStartingMenu();
        }




    }
}








