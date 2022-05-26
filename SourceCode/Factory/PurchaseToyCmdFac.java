package SourceCode.Factory;

import SourceCode.Command.*;
import SourceCode.ToyProduct.ToyProduct;
import SourceCode.Main;

import java.util.Vector;

public class PurchaseToyCmdFac implements CmdFac {
    private Vector<ToyProduct> toys;

    public Cmd create() throws Exception {
        ToyProduct _toyProduct = null;
        int productID, qty;
        double cost;

        System.out.println("Enter code: ");
        productID = Integer.parseInt(Main.sc.nextLine());
        for (ToyProduct toyProduct: toys) { // search id from record
            if (toyProduct.getProductID() == productID) {
                _toyProduct = toyProduct;
            }
        }
        // check the error after every input
        if (_toyProduct == null) {
            System.out.println("ID: " + productID + " not found.");
            return null;
        }

        System.out.println("Quantity to be purchased:");
        qty = Integer.parseInt(Main.sc.nextLine());
        if (qty <= 0){
            System.out.println("Quantity can not less then or equal to 0");
            return null;
        }
        System.out.println("Purchasing cost:");
        cost = Integer.parseInt(Main.sc.nextLine());
        if (cost <= 0){
            System.out.println("Cost can not less then 0");
            return null;
        }

        return new PurchaseToy(_toyProduct, qty, cost);
    }

    public void setToys(Vector<ToyProduct> toys) {
        this.toys = toys;
    }
}
