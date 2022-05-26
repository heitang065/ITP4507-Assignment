package SourceCode.Command;

import SourceCode.ToyProduct.*;

import java.util.Vector;

public class CreateRC extends CreateToy {
    private double maxSpeed;

    public CreateRC(Vector<ToyProduct> toys, int productID, String name, double maxSpeed) {
        super(toys, productID, name);
        this.maxSpeed = maxSpeed;
    }

    public void execute() {
        toy = new RemoteControlCar(productID, name, maxSpeed);
        toys.add(toy);
        System.out.println("New toy product record created.");
    }
}
