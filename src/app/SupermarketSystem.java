package app;

import model.*;
import service.ProductFactory;
import util.InputValidator;

import java.util.Scanner;

public class SupermarketSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SUPERMARKET SYSTEM ===");

        // CATEGORY (NOW 6 OPTIONS)
        String category = InputValidator.getValidCategory(sc);

        // PRODUCT INPUT
        String id = InputValidator.getUniqueProductId(sc);
        String name = InputValidator.getValidString(sc, "Enter product name: ");
        double price = InputValidator.getValidDouble(sc, "Enter price: ");
        int quantity = InputValidator.getValidInt(sc, "Enter quantity: ");

        // FACTORY CREATION (POLYMORPHISM)
        InventoryManager product =
                ProductFactory.createProduct(category, id, name, price, quantity);

        // CUSTOMER INPUT
        String customerId = InputValidator.getValidString(sc, "Enter customer ID: ");
        String customerName = InputValidator.getValidString(sc, "Enter customer name: ");
        String phone = InputValidator.getValidPhone(sc, "Enter phone (10 digits): ");

        Customer customer = new Customer(customerId, customerName, phone);

        // ORDER INPUT WITH VALIDATION
        int orderQty;
        while (true) {
            orderQty = InputValidator.getValidInt(sc, "Enter order quantity: ");

            if (!product.checkAvailability(orderQty)) {
                System.out.println("❌ Not enough stock available.");
            } else {
                break;
            }
        }

        // PROCESS SALE
        product.processSale(orderQty);

        Order order = new Order("ORD-001", product, orderQty);

        // OUTPUT
        System.out.println("\n=== SYSTEM OUTPUT ===");
        System.out.println(product);
        System.out.println(customer);
        System.out.println(order);

        sc.close();
    }
}