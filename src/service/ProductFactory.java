package service;

import model.InventoryManager;
import model.products.*;

public class ProductFactory {

    public static InventoryManager createProduct(
            String category,
            String id,
            String name,
            double price,
            int qty) {

        switch (category.toLowerCase()) {

            case "food":
                return new FoodProduct(id, name, price, qty,
                        "DefaultSupplier", "A1", "2026-12-31");

            case "beverage":
                return new BeverageProduct(id, name, price, qty,
                        "DefaultSupplier", "A2", true);

            case "electronics":
                return new ElectronicProduct(id, name, price, qty,
                        "DefaultSupplier", "B1", 12);

            case "clothing":
                return new ClothingProduct(id, name, price, qty,
                        "DefaultSupplier", "C1", "M");

            case "cleaning":
                return new CleaningProduct(id, name, price, qty,
                        "DefaultSupplier", "D1", "Liquid");

            case "personalcare":
                return new PersonalCareProduct(id, name, price, qty,
                        "DefaultSupplier", "E1", "Skin");

            default:
                throw new IllegalArgumentException("Invalid category");
        }
    }
}