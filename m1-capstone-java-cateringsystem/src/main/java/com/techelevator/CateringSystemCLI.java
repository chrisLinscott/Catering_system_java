package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
<<<<<<< HEAD
import com.techelevator.items.Customer;
import com.techelevator.items.ShoppingCart;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.HashMap;
=======
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
>>>>>>> 979a68030f5326248d64a13fd65a2379b2bf7fad
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
            cateringItemMap = inventoryFileReader.readFileInventory();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cateringSystem = new CateringSystem(inventoryFileReader.getCateringItemMap());


//        try {
//            //this is probably not necessary....TBD
//            cateringItemMap = inventoryFileReader.readFileInventory();
//        } catch (FileNotFoundException e) {
//            menu.fileNotFoundError();
//        }
        while (true) {
            String menuOneOutput = menu.menuOutput();
            // next two lines are ok, cant make more concise
            if (menuOneOutput.equals("1")) {
                menu.PrintCateringItems(cateringItemMap);
                menu.printStartingMenu();
            } else if (menuOneOutput.equals("2")) {
                //instead of our previous break, go to next method
                runSubMenuTwo();
            } else { //this closes the program and should go to exit code , make menu method to display closing message.
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
        if (menu.menuOutput().equals("2")) {

            menu.PrintCateringItems(cateringItemMap);
            menu.ShowCustomerPurchase();
            String itemsProductCode = menu.menuOutput();

            menu.UserEnteredQuantity();
            int quantityDesired = menu.PurchaseMenuOutput();
            if (!(cateringItemMap.containsKey(itemsProductCode))) {
                menu.singleLineMessages("Sorry, product does not exist");
                menu.printSubMenu2();
            }
            if (cateringItemMap.get(itemsProductCode).getQuantity() < quantityDesired) {
                menu.singleLineMessages("Sorry, there is not enough product in stock");
                menu.printSubMenu2();
            }
            if (!(cateringSystem.getCurrentAccountBalance() >= cateringItemMap.get(itemsProductCode).getPrice())) {
                menu.singleLineMessages("Sorry, you don't have enough money for this");
                menu.printSubMenu2();
            }
            if (cateringItemMap.get(itemsProductCode).getQuantity() == 0) {
                menu.singleLineMessages("Product out of stock!");
                menu.printSubMenu2();
            }
            if (cateringItemMap.containsKey(itemsProductCode) && cateringItemMap.get(itemsProductCode).getQuantity() >= quantityDesired && cateringSystem.getCurrentAccountBalance() >= cateringItemMap.get(itemsProductCode).getPrice()) {
                cateringSystem.addToCart(itemsProductCode, quantityDesired);

                //cateringSystem.updatingBalanceAfterShopping(cateringItemMap.get(itemsProductCode).getPrice(), quantityDesired);
                menu.printSubMenu2();
                menu.ShowCurrentBalance(cateringSystem.updatingBalanceAfterShopping(cateringItemMap.get(itemsProductCode).getPrice(), quantityDesired));
                //everything above this line is ok.
             // doesnt work right now   cateringSystem.updatingItemQuantityInMap(itemsProductCode, quantityDesired);
                menu.PrintCateringItems(cateringItemMap);

            }

        } else if (menu.menuOutput().equals("3"))
        {

            menu.printReceipt(cateringItemMap, 3);
            cateringSystem.makeChange();
            System.out.println();
            //resets balance
            //cateringSystem.resetBalance();


        }




    }
}








