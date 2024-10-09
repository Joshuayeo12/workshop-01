package shoppingcart;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

    public static void main(String[] args) {
        
        //List of shopping goods
        ArrayList<String> cart = new ArrayList<String>();
        cart.add("apples");
        cart.add("orange");
        cart.add("pear");
        cart.add("grapes");

        boolean stop = false;
        Console cons = System.console();
        System.out.println("Welcome to your shopping cart");
        //while loop to ensure that i can add or remove
        while (!stop){
            String cmd = cons.readLine("CMD (ADD, REMOVE, SHOW, EXIT)>").trim().toUpperCase();

            switch (cmd) {
                case "ADD":
                    String itemToAdd = cons.readLine("Items to Add>").trim();
                    cart.add(itemToAdd);
                    System.out.printf("Added %s\n", itemToAdd);
                    break;

                case "REMOVE":
                    String itemToRemove = cons.readLine("Item to Remove>").trim();
                    if (cart.remove(itemToRemove)) {
                        System.out.printf("Removed: %s\n", itemToRemove);
                    }
                    else{
                        System.err.println("Item not found in cart");
                    }
                    break;
                    case "SHOW":
                    System.out.println("Items in cart:");
                    if (cart.isEmpty()) {
                       System.out.println("Cart is empty.");
                    } else {
                       for (String item : cart) {
                          System.out.println("- " + item);
                       }
                    }
                    break;

                    case "EXIT":
                    stop = true;
                    System.out.println("Exiting...");
                    break;
    
                default:
                System.err.println("Invalid command");
                    break;
            
                }








        }


        
        
        
       



    }

}
