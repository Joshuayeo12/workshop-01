package shoppingcart;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static ArrayList<String> cart = new ArrayList<>();
    private static List<String> userList = new ArrayList<>();
    private static String userName = "";

    public static void main(String[] args) {

        // Initialize shopping goods
        cart.add("apples");
        cart.add("orange");
        cart.add("pear");
        cart.add("grapes");

        boolean stop = false;
        Console cons = System.console();
        ShoppingCart shoppingCart = new ShoppingCart();
        

        if (cons == null) {
            System.err.println("No console found!");
            return;
        }

        // Load database path based on args
        if (args.length == 1) {
            String cbd = "/Users/joshuayeo/Desktop/nuscoding/SDF/workshop03/myApp/cartdb";
            System.out.println(cbd + " database is being accessed");
        } else {
            System.out.println("Unable to connect to the database");
        }

        System.out.println("Welcome to your shopping cart");

        // Loop to handle user commands
        while (!stop) {
            String input = cons.readLine("CMD (ADD, REMOVE, SHOW, EXIT, LOGIN, SAVE, USERS)>").trim().toUpperCase();
            String[] terms = input.split(" ");

            switch (terms[0]) {

                case "LOGIN":
                    if (terms.length == 1) {
                        System.out.println("Please input name after 'LOGIN'");
                    } else {
                        String customer = terms[1];
                    
                        if (!userList.contains(customer)) {
                            userList.add(customer);
                            userName = customer;
                            System.out.println("User " + customer + " logged in.");
                        } else {
                            System.out.println(customer + " is already logged in");
                        }
                    }
                    break;

                case "SAVE":
                    if (userName.isEmpty()) {
                        System.out.println("Please log in before saving.");
                    } else {
                        System.out.println("Saving account details for " + userName);
                        // Add logic to save cart details for userName
                    }
                    break;

                case "USERS":
                System.out.println("Here are the list of users for the shopping cart");
                for(int i = 0; i < userList.size(); i++) {
                    System.out.println((i+1) + "." + userList.get(i));
                }


                case "ADD":
                    String itemToAdd = cons.readLine("Items to Add>").trim();
                    cart.add(itemToAdd);
                    System.out.printf("Added %s\n", itemToAdd);
                    break;

                case "REMOVE":
                    String itemToRemove = cons.readLine("Item to Remove>").trim();
                    if (cart.remove(itemToRemove)) {
                        System.out.printf("Removed: %s\n", itemToRemove);
                    } else {
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
