package SourceCode.Factory;

import SourceCode.Command.*;
import SourceCode.ToyProduct.ToyProduct;
import SourceCode.Main;

import java.util.*;

public class CreateToyCmdFac implements CmdFac {
    protected Vector<ToyProduct> toys;
    protected int productID;
    protected String name;

    public Cmd create() throws Exception {
        // Create a hashmap to store all the command
        HashMap<String, String> toyFactoryMap = new HashMap<String, String>() {
            {
                put("ro", "CreateROCmdFac");
                put("rc", "CreateRCCmdFac");
            }
        };
        System.out.println("Enter toy type(ro=Robot/rc=Remote Control Car): ");
        String line = Main.sc.nextLine();
        line = line.toLowerCase();

        // system will loop asking the type if user enter wrong type
        while (!(line.equals("ro") || line.equals("rc"))) {
            System.out.println("Please enter correct type");
            System.out.println("Enter toy type(ro=Robot/rc=Remote Control Car): ");
            line = Main.sc.nextLine();
            line = line.toLowerCase();
        }
        String factory = toyFactoryMap.get(line);
             
        CreateToyCmdFac createToy = (CreateToyCmdFac) Class.forName("SourceCode.Factory." + factory).newInstance();
        createToy.setToys(toys);
        
        return createToy.create();
    }

    public void setToys(Vector<ToyProduct> toys) {
        this.toys = toys;
    }
}
