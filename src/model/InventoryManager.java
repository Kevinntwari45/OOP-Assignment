package model;

import interfaces.Sellable;

public class InventoryManager extends Product implements Sellable {

    private String supplierName;
    private String storageLocation;

    public InventoryManager() {}

    public InventoryManager(String id, String name, double price, int quantity, String category,
                            String supplierName, String storageLocation) {
        super(id, name, price, quantity, category);
        this.supplierName = supplierName;
        this.storageLocation = storageLocation;
    }

    // Abstract implementations
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public double applyTax() {
        return getPrice() * 0.18;
    }

    @Override
    public boolean checkAvailability(int qty) {
        return getQuantity() >= qty;
    }

    @Override
    public double calculateTotalValue() {
        return getPrice() * getQuantity();
    }

    @Override
    public void updateStock(int qty) {
        setQuantity(getQuantity() - qty);
    }

    @Override
    public boolean validateProduct() {
        return getPrice() > 0 && getQuantity() >= 0;
    }

    @Override
    public String generateReport() {
        return "Report: " + toString();
    }

    @Override
    public String getCategoryDescription() {
        return "General product category";
    }

    // Sellable methods
    @Override
    public void processSale(int quantity) {
        if (checkAvailability(quantity)) {
            updateStock(quantity);
            System.out.println("Sale processed!");
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    @Override
    public double calculateFinalPrice(int quantity) {
        return (getPrice() - calculateDiscount() + applyTax()) * quantity;
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt: " + toString());
    }

    @Override
    public String toString() {
        return super.toString() + ", Supplier: " + supplierName +
               ", Location: " + storageLocation;
    }
}