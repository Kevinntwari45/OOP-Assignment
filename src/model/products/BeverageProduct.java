package model.products;

import model.InventoryManager;

public class BeverageProduct extends InventoryManager {

    private boolean isAlcoholic;

    public BeverageProduct(String id, String name, double price, int qty,
                           String supplier, String location, boolean isAlcoholic) {
        super(id, name, price, qty, "Beverage", supplier, location);
        this.isAlcoholic = isAlcoholic;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    @Override
    public String getCategoryDescription() {
        return "Drinkable product";
    }

    @Override
    public String toString() {
        return super.toString() + ", Alcoholic: " + isAlcoholic;
    }
}