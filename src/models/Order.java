package models;

import java.util.Vector;

public class Order {
    private double subtotal;
    private double tax;
    private double total;
    private double totalWeight;
    private Vector<CartItem> items;

    public Order(Vector<CartItem> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }



    public double getTotal() {
        return total;
    }



    public double getTotalWeight() {
        return totalWeight;
    }


    public void calculateSubtotal() {
            for (CartItem item : items) {
               this.subtotal += item.getProduct().getPrice() * item.getQuantity();
            }
    }
    public void calculateTotalWeight() {
        for (CartItem item : items) {
            this.totalWeight += item.getProduct().getWeight() * item.getQuantity();
        }
    }
    public void calculateTotal() {
        this.total = this.subtotal + this.tax;
    }

    public void calculateTax(double taxRate) {
        this.tax = subtotal * taxRate;
    }

    public void printReceipt(){
        calculateSubtotal();
        calculateTotalWeight();
        calculateTotal();
        calculateTax(0.08); // Example tax rate
        System.out.println("Order Receipt:");
        System.out.println("Subtotal: " + this.subtotal);
        System.out.println("Tax: " + this.tax);
        System.out.println("Total: " + this.total);
        System.out.println("Total Weight: " + this.totalWeight);
        System.out.println("--------------------------------------");
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() + ": " + item.getQuantity() + "x " + item.getProduct().getPrice());
        }
        System.out.println("--------------------------------------");
    }

}
