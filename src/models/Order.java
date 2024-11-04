package models;

import errors.CartEmptyException;

import java.util.Vector;

public class Order {
    private double subtotal;
    private double shippingCost;
    private double total;
    private double totalWeight;
    private Vector<CartItem> items;
    private Customer customer;
    private Vector<CartItem> shipmentsList = new Vector<>();

    public Order(Vector<CartItem> items,Customer customer) {
        this.items = items;
        this.customer = customer;
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
           this.subtotal = 0.0;
            for (CartItem item : items) {
               this.subtotal += item.getProduct().getPrice() * item.getQuantity();
            }
    }
    public void calculateTotalWeight() {
        this.totalWeight = 0.0;
        for (CartItem item : items) {
            this.totalWeight += item.getProduct().getWeight() * item.getQuantity();
        }
    }
    public void calculateTotal() {
        this.total = 0.0;
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
        this.shippingCost = 0.0;
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

    public void printReceipt()  {
      try {
           if(items.isEmpty())
              throw new CartEmptyException("Cart is empty.");
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
            System.out.println("Your Cuurent Balance is : " + this.customer.getBalance());
            System.out.println("--------------------------------------");
            System.out.println("Thanks for trusting us," + this.customer.getName() + " ❤");
        } catch (CartEmptyException e) {
            System.out.println(e.getMessage());
        }


    }

}
