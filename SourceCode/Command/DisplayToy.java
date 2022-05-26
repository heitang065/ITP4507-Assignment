package SourceCode.Command;

import SourceCode.ToyProduct.ToyProduct;

import java.util.Vector;

public class DisplayToy implements Cmd {
    private Vector<ToyProduct> toys;
    private String type;

    public DisplayToy(Vector<ToyProduct> toys, String type) {
        this.toys = toys;
        this.type = type;
    }

    public void execute() {
        if (type.equals("*")) { // display all record
            System.out.println("\nToy product information");
            String table = "%-8s%-20s%-12s%-15s%-8s%-8s\n";
            System.out.printf(table, "ID", "Name", "Quantity", "Other Info", "Cost", "Price");
            
            for (ToyProduct toyProduct: toys) {
                String[] list = toyProduct.toString().split("\n");
                String id = getToyValue(list[0]);
                String name = getToyValue(list[1]);
                String quantity = getToyValue(list[2]);
                String otherInfo = getToyValue(list[5]);
                String otherInfoType = getToyType(list[5]);
                String cost = getToyValue(list[3]);
                String price = getToyValue(list[4]);

                // add the unit to corresponding position
                if (otherInfoType.equals("Height(cm)")) {
                    otherInfoType = "cm";
                } else {
                    otherInfoType = "km/hr";
                }
                System.out.printf(table, id, name, quantity, otherInfo + otherInfoType, cost, price);
            }
        } else {
            try {
                // to check the specific id from record
                int productID = Integer.parseInt(type);
                ToyProduct _toyProduct = null;
                for (ToyProduct toyProduct: toys) {
                    if (toyProduct.getProductID() == productID) {
                        _toyProduct = toyProduct;
                    }
                }
                if (_toyProduct != null) {
                    System.out.println("\nToy product information");
                    System.out.println(_toyProduct);
                } else { // checking error
                    System.out.println("ID: " + productID + " not found.");
                }
            } catch (Exception e) {
                System.out.println("*** " + e.getMessage());
            }
        }
    }

    private String getToyValue(String value) {
        return value.split(": ")[1];
    }

    private String getToyType(String value) {
        return value.split(": ")[0];
    }
}
