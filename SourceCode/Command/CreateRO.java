package SourceCode.Command;

import SourceCode.ToyProduct.*;

import java.util.Vector;

public class CreateRO extends CreateToy {
    private double height;

    public CreateRO(Vector<ToyProduct> toys, int productID, String name, double height) {
        super(toys, productID, name);
        this.height = height;
    }

    public void execute() {
        toy = new Robot(productID, name, height);
        toys.add(toy);
        System.out.println("New toy product record created.");
    }
}
