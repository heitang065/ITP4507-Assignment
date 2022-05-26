package SourceCode.Command;

import SourceCode.ToyProduct.*;

import java.util.Vector;

public class CreateToy implements Cmd {
    protected Vector<ToyProduct> toys;
    protected ToyProduct toy;
    protected int productID;
    protected String name;

    public CreateToy(Vector<ToyProduct> toys, int productID, String name) {
        this.toys = toys;
        this.productID = productID;
        this.name = name;
    }

    public void execute() {}

    public String toString() {
        return "Create " + toy.getProductID() + " " + toy.getName();
    }
}
