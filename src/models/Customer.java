public class Customer {
    private String name;
    private double balance;



    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Boolean isBalanceSufficient(Product product){
        return product.getPrice() <= this.balance;
    }
    public void updateBalance (int productPrice){
        this.balance-=productPrice;
    }

}
