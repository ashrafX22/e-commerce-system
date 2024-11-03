package models;

import java.util.Vector;

public class Order {
    private double subtotal;
    private double shippingCost;
    private double total;
    private double totalWeight;
    private Vector<CartItem> items;
    private Vector<CartItem> shipmentsList = new Vector<>();

    public Order(Vector<CartItem> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }


    public double getShippingCost() {
        return this.shippingCost;
    }



    public double getTotal() {
        return this.total+this.shippingCost;
    }



    public double getTotalWeight() {
        return this.totalWeight;
    }
    public Vector<CartItem> getShippedItems() {
        return this.shipmentsList;
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
        this.total = this.subtotal + this.getShippingCost();
    }



    public void countShippedItems() {
        for (CartItem item : items) {
            if (item.getProduct().requiresShipping()) {
                this.shipmentsList.add(item);
            }
        }
    }
    public void calculateShippingCost() {
        for(CartItem item:shipmentsList){
            this.shippingCost += item.getProduct().getWeight() * item.getQuantity() * 0.05;  // 5% of product weight as shipping cost
        }
    }

    public void printShipments() {
        calculateShippingCost();
        double totalShipmentWeight = 0.0;
        System.out.println("Shipped Items:");
        for (CartItem item : shipmentsList) {
            System.out.println(item.getProduct().getName() + ": " + item.getQuantity() + "x " + item.getProduct().getWeight() + "kg");
            totalShipmentWeight += item.getProduct().getWeight() * item.getQuantity();
        }
        System.out.println("Total Package Weight: " + totalShipmentWeight+ "kg");
        System.out.println("--------------------------------------");
    }

    public void printReceipt(){
        countShippedItems();
        calculateSubtotal();
        calculateTotalWeight();
        calculateTotal();
        if(!this.shipmentsList.isEmpty())
            printShipments();
        System.out.println("Order Receipt:");
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() + ": " + item.getQuantity() + "x " + item.getProduct().getPrice()+"$");
        }
        System.out.println("--------------------------------------");
        System.out.println("Subtotal: " + getSubtotal());
        System.out.println("shipping cost: " + getShippingCost());
        System.out.println("Total: " + getTotal());
        System.out.println("Total Weight: " + getTotalWeight() + "kg");
        System.out.println("--------------------------------------");

    }

}
