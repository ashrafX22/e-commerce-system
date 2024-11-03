import models.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            // Create a customer with initial balance
            Customer customer = new Customer("ashraf maged", 10000000.0);

            // List of products to test with
            Product laptop = new Product("Laptop", 1500.0, 100, 13,true, true);
            Product bike = new Product("bike", 1500.0, 100,34, true, false);
            Product tv = new Product("tv", 1500.0, 100, 24,true, false);
            Product oven = new Product("oven", 1500.0, 100,80, true, false);
            Product pizza = new Product("   pizza", 1500.0, 100,1,true,true);
            Product book = new Product("book", 1500.0, 100,0.5,true, true);
            Product shoes = new Product("shoes", 1500.0, 100,0.2,true, true);
            Product chair = new Product("chair", 1500.0, 100,0.1,true, true);
            Product hat = new Product("hat", 1500.0, 100,0.1,true, false);

            // Add the product to the customer's cart
            Cart cart = new Cart(customer);
//            cart.add(laptop, 5);
            cart.add(bike, 50);
//            cart.add(tv, 5);
            cart.add(oven, 4);
            // add or remove items of the cart


            // making an order
             Order order = new Order(cart.getItems(),customer);
             order.printReceipt();

             cart.remove(bike);
             order.printReceipt();

        }
    }
