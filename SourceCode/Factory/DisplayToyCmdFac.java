package SourceCode.Factory;

import SourceCode.Command.*;
import SourceCode.ToyProduct.ToyProduct;
import SourceCode.Main;

import java.util.Vector;

public class DisplayToyCmdFac implements CmdFac {
    private Vector<ToyProduct> toys;

    public Cmd create() throws Exception {

        System.out.println("Enter ID(* to display all): ");
        String id = Main.sc.nextLine();

        return new DisplayToy(toys, id);
    }

    public void setToys(Vector<ToyProduct> toys) {
        this.toys = toys;
    }
}
