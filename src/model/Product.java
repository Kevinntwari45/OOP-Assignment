package model;

public abstract class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String category;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(String productId, String productName, double price, int quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters & Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // Abstract methods (8)
    public abstract double calculateDiscount();
    public abstract double applyTax();
    public abstract boolean checkAvailability(int quantity);
    public abstract double calculateTotalValue();
    public abstract void updateStock(int quantity);
    public abstract boolean validateProduct();
    public abstract String generateReport();
    public abstract String getCategoryDescription();

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName +
               ", Price: " + price + ", Quantity: " + quantity +
               ", Category: " + category;
    }
}