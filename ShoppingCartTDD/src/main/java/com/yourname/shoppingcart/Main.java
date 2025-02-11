package com.yourname.shoppingcart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== SHOPPING CART MENU ====");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Change quantity");
            System.out.println("4. View cart");
            System.out.println("5. Drop cart");
            System.out.println("6. Checkout");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String addItem = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int addQuantity = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        cart.addItem(addItem, addQuantity);
                        System.out.println("Added " + addQuantity + " " + addItem + "(s) to the cart.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeItem = scanner.nextLine();

                    try {
                        cart.removeItem(removeItem);
                        System.out.println("Removed " + removeItem + " from the cart.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter item name to update: ");
                    String updateItem = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    try {
                        cart.changeQuantity(updateItem, newQuantity);
                        System.out.println("Updated " + updateItem + " to quantity " + newQuantity + ".");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Current Cart: " + cart.getItems());
                    break;

                case 5:
                    cart.dropCart();
                    System.out.println("Cart has been emptied.");
                    break;

                case 6:
                    try {
                        if (cart.checkout()) {
                            System.out.println("Checkout successful!");
                        }
                    } catch (IllegalStateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Exiting Shopping Cart. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please choose a valid number.");
            }
        }
    }
}
