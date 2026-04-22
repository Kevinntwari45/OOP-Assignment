package model.products;

import model.InventoryManager;

public class PersonalCareProduct extends InventoryManager {

    private String careType;

    public PersonalCareProduct(String id, String name, double price, int qty,
                               String supplier, String location, String careType) {
        super(id, name, price, qty, "PersonalCare", supplier, location);
        this.careType = careType;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.12;
    }

    @Override
    public String getCategoryDescription() {
        return "Personal care product";
    }

    @Override
    public String toString() {
        return super.toString() + ", Care Type: " + careType;
    }
}