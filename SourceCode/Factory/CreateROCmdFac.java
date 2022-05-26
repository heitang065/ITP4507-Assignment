package SourceCode.Factory;

import SourceCode.Command.*;
import SourceCode.Main;
import SourceCode.ToyProduct.*;

public class CreateROCmdFac extends CreateToyCmdFac {
    public Cmd create() throws Exception {

        System.out.println("Enter id, name and height(cm): ");
        String line = Main.sc.nextLine();
        String[] lineArr = line.split(","); // split user input to an array by ","
        for (int i = 0; i < lineArr.length; i++) {
            lineArr[i] = lineArr[i].trim(); // remove the space
        }
        
        productID = Integer.parseInt(lineArr[0]);
        name = lineArr[1];
        double height = Integer.parseInt(lineArr[2]);

        // search id from record
        ToyProduct _toyProduct = null;
        for (ToyProduct toyProduct: toys) {
            if (toyProduct.getProductID() == productID) {
                _toyProduct = toyProduct;
            }
        }

        // checking error
        if (_toyProduct != null) {
            System.out.println("ID duplicated.");
            return null;
        } else if (height <= 0) {
            System.out.println("Height can not less than or equal to 0.");
            return null;
        } else if (lineArr.length != 3) {
            System.out.println("Please enter all the information.");
            return null;
        }

        return new CreateRO(toys, productID, name, height);
    }
}
