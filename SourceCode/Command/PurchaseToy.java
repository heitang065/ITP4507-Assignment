package SourceCode.Command;

import SourceCode.ToyProduct.ToyProduct;

public class PurchaseToy implements Cmd {
    private ToyProduct toyProduct;
    private int qty;
    private double cost;

    public PurchaseToy(ToyProduct toyProduct, int qty, double cost) {
        this.toyProduct = toyProduct;
        this.qty = qty;
        this.cost = cost;
    }

    public void execute() {
        toyProduct.setQty(toyProduct.getQty() + qty);
        toyProduct.setCost(toyProduct.getCost() + cost);
        System.out.println("Purchased " + qty + " boxes of " + 
                            toyProduct.getName() + ". Current quantity is " + 
                            qty + ". Current cost is $" + cost + 
                            ". Price is $" + toyProduct.getPrice() + ".");
    }

    public String toString() {
        return "Purchase " + qty + toyProduct.getProductID() + " " + 
                toyProduct.getName() + " " + toyProduct.getPrice();
    }
}
