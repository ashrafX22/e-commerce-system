public class Product {
    private String name;
    private double price;
    private int quantity;
    private boolean isExpirable;
    private boolean requiresShipping;
    public Product(String name, double price, int quantity, boolean isExpirable, boolean requiresShipping) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.requiresShipping = requiresShipping;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
}
