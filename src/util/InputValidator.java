package util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputValidator {

    private static final Set<String> usedProductIds = new HashSet<>();

    // STRING VALIDATION
    public static String getValidString(Scanner sc, String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("❌ Input cannot be empty.");
            } else {
                return input;
            }
        }
    }

    // DOUBLE VALIDATION
    public static double getValidDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());

                if (value <= 0) {
                    System.out.println("❌ Value must be greater than 0.");
                } else {
                    return value;
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number format.");
            }
        }
    }

    // INTEGER VALIDATION
    public static int getValidInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());

                if (value <= 0) {
                    System.out.println("❌ Value must be greater than 0.");
                } else {
                    return value;
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid integer.");
            }
        }
    }

    // PHONE VALIDATION
    public static String getValidPhone(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String phone = sc.nextLine();

            if (!phone.matches("\\d{10}")) {
                System.out.println("❌ Phone must be 10 digits.");
            } else {
                return phone;
            }
        }
    }

    // CATEGORY VALIDATION
    public static String getValidCategory(Scanner sc) {
    while (true) {
        System.out.println("\nAvailable categories:");
        System.out.println("1. food");
        System.out.println("2. beverage");
        System.out.println("3. electronics");
        System.out.println("4. clothing");
        System.out.println("5. cleaning");
        System.out.println("6. personalcare");

        System.out.print("Enter category (name or number): ");
        String input = sc.nextLine().toLowerCase().trim();

        switch (input) {
            case "1":
            case "food":
                return "food";

            case "2":
            case "beverage":
                return "beverage";

            case "3":
            case "electronics":
                return "electronics";

            case "4":
            case "clothing":
                return "clothing";

            case "5":
            case "cleaning":
                return "cleaning";

            case "6":
            case "personalcare":
                return "personalcare";

            default:
                System.out.println("❌ Invalid category. Choose from the list.");
        }
    }
}

    // UNIQUE PRODUCT ID
    public static String getUniqueProductId(Scanner sc) {
        while (true) {
            System.out.print("Enter Product ID: ");
            String id = sc.nextLine();

            if (id.isEmpty()) {
                System.out.println("❌ ID cannot be empty.");
            } else if (usedProductIds.contains(id)) {
                System.out.println("❌ Duplicate ID. Try again.");
            } else {
                usedProductIds.add(id);
                return id;
            }
        }
    }
}