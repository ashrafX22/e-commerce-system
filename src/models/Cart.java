package models;

import errors.InsufficientBalanceException;
import errors.InsufficientQuantityException;

import java.util.Vector;

public class Cart {
    private Vector<CartItem> items = new Vector<CartItem>();
    private Customer customer;

    public Vector<CartItem> getItems() {
        return items;
    }


    public Cart(Customer customer) {
        this.customer = customer;
    }

    public void add(Product item, int amount) {
        try {
            if (item.getQuantity() < amount) {
                throw new InsufficientQuantityException("Insufficient quantity of product: " + item.getName());
            }

            if (item.getPrice() * amount > this.customer.getBalance()) {
                throw new InsufficientBalanceException("Insufficient balance for product: " + item.getName());
            }
            this.items.add(new CartItem(item, amount));

            item.setQuantity(item.getQuantity() - amount);
            this.customer.updateBalance((int) (item.getPrice() * amount));
        } catch (InsufficientQuantityException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}