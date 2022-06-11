package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;

import com.techelevator.items.ShoppingCart;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
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
    private CateringSystem cateringSystem;


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
//run method very short, only runs program, will use another method to run sub-menus
        menu.showWelcomeMessage();

        inventoryFileReader = new InventoryFileReader("cateringsystem.csv");
        cateringSystem = new CateringSystem(inventoryFileReader.getCateringItemMap());
        menu.printStartingMenu();
        try {
            //this is probably not necessary....TBD
            cateringItemMap = inventoryFileReader.readFileInventory();
        } catch (FileNotFoundException e) {
            menu.fileNotFoundError();
        }
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

                } else {
                    Float workingBalance = cateringSystem.getCurrentAccountBalance();
                    menu.printSubMenu2();
                    menu.ShowCurrentBalance(workingBalance);



// this needs to be a method to put items in cart in CateringSystem.
            } if (menu.menuOutput().equals("2")) {
                menu.PrintCateringItems(cateringItemMap);
               // menu.ShowcateringSystemPurchase();
                String itemsProductCode = menu.menuOutput();
                if (cateringItemMap.containsKey(itemsProductCode)) {

                    menu.UserEnteredQuantity();
                }
                int quantityDesired = menu.PurchaseMenuOutput();
            if (cateringItemMap.get(itemsProductCode).getQuantity() >= quantityDesired && cateringSystem.getCurrentAccountBalance() >= cateringItemMap.get(itemsProductCode).getPrice() * quantityDesired) {
                //calling method to add to cart instead of it all being here
               cateringSystem.addToCart(itemsProductCode, quantityDesired);

                    // shoppingCart=new ShoppingCart()
                    //
                    //  if(quantityDesired* cateringItemMap.get(menu.menuOutput())<= cateringSystem.getCurrentAccountBalance() )

                }
            } else {

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







