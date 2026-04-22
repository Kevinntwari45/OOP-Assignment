package model.products;

import model.InventoryManager;

public class ClothingProduct extends InventoryManager {

    private String size;

    public ClothingProduct(String id, String name, double price, int qty,
                           String supplier, String location, String size) {
        super(id, name, price, qty, "Clothing", supplier, location);
        this.size = size;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.25;
    }

    @Override
    public String getCategoryDescription() {
        return "Clothing item";
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}