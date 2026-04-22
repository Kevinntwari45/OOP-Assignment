package model;

public class Order {
    private String orderId;
    private Product product;
    private int quantity;
    private double totalPrice;

    public Order(String orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = calculateTotalPrice();
    }

    public double calculateTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
               ", Product: " + product.getProductName() +
               ", Quantity: " + quantity +
               ", Total: " + totalPrice;
    }
}