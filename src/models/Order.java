package models;

public class Order {
    private double subtotal;
    private double tax;
    private double total;
    private double totalWeight;

    public Order(double subtotal, double tax, double total, double totalWeight) {
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
        this.totalWeight = totalWeight;
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

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }
}
