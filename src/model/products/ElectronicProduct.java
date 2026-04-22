package model.products;

import model.InventoryManager;

public class ElectronicProduct extends InventoryManager {

    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int qty,
                             String supplier, String location, int warranty) {
        super(id, name, price, qty, "Electronics", supplier, location);
        this.warrantyMonths = warranty;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.25;
    }

    @Override
    public String getCategoryDescription() {
        return "Electronic device";
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyMonths + " months";
    }
}