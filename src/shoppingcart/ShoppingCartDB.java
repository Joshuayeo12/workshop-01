package shoppingcart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ShoppingCartDB {private String directory;
    private String userName;

    public ShoppingCartDB(String directory, String userName) {
        this.directory = directory;
        this.userName = userName;
    }

    public boolean userExists() {
        Path userFilePath = Paths.get(directory, userName + ".db");
        return Files.exists(userFilePath);
    }

    public void createUserFile() {
        try {
            Path userFilePath = Paths.get(directory, userName + ".db");
            Files.createFile(userFilePath);
        } catch (Exception e) {
            System.err.println("Error creating user file: " + e.getMessage());
        }
    }

    public void saveCart(ArrayList<String> cart) {
        try {
            Path userFilePath = Paths.get(directory, userName + ".db");
            Files.write(userFilePath, cart);  // Write the cart to the file
        } catch (Exception e) {
            System.err.println("Error saving cart: " + e.getMessage());
        }
    }
}