package model.products;

import model.InventoryManager;

public class CleaningProduct extends InventoryManager {

    private String chemicalComposition;

    public CleaningProduct(String id, String name, double price, int qty,
                           String supplier, String location, String chemicalComposition) {
        super(id, name, price, qty, "Cleaning", supplier, location);
        this.chemicalComposition = chemicalComposition;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.25;
    }

    @Override
    public String getCategoryDescription() {
        return "Cleaning product";
    }

    @Override
    public String toString() {
        return super.toString() + ", Chemical: " + chemicalComposition;
    }
}