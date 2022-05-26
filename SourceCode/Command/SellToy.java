package SourceCode.Command;

import SourceCode.ToyProduct.ToyProduct;

public class SellToy implements Cmd {
    private ToyProduct toyProduct;
    private int qty;
    private double price;

    public SellToy(ToyProduct toyProduct, int qty, double price) {
        this.toyProduct = toyProduct;
        this.qty = qty;
        this.price = price;
    }

    public void execute() {
        toyProduct.setQty(toyProduct.getQty() - qty);
        toyProduct.setPrice(toyProduct.getPrice() + price);
        System.out.println("Sold " + qty + " boxes of " + 
                            toyProduct.getName() + ". Current quantity is " + 
                            toyProduct.getQty() + ". Selling price is $" + price + ".");
    }

    public String toString() {
        return "Sell " + qty + toyProduct.getProductID() + " " + 
                toyProduct.getName() + " " + toyProduct.getPrice();
    }
}
