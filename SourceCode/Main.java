package SourceCode;

import SourceCode.Command.*;
import SourceCode.Factory.*;

import java.util.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
		Vector toys = new Vector<>();

        // Create a hashmap to store all the command
        HashMap<String, String> factoryMap = new HashMap<String, String>() {
            {
                put("c", "CreateToyCmdFac");
                put("d", "DisplayToyCmdFac");
                put("p", "PurchaseToyCmdFac");
                put("s", "SellToyCmdFac");
                put("u", "UndoCmdFac"); // not finish
                put("r", "RedoCmdFac"); // not finish
                put("l", "DisplayListCmdFac"); // not finish
            }
        };

		while (true) {
			try {
                System.out.println("Toy Inventory Management System (TIMS)\n" + 
                                    "Please enter command: [ c | d | p | s | u | r | l | x ]\n" +
                                    "c = create toy, d = display toy, p = purchase toy, s = sell toy,\n" +
                                    "u = undo, r = redo, l = list undo/redo, x = exit system");
				String option = sc.nextLine();
                option = option.toLowerCase();
				String factory = factoryMap.get(option);
                if (factory != null) { // to read the specific command factory
                    CmdFac cmdFac = (CmdFac) Class.forName("SourceCode.Factory." + factory).newInstance();
                    cmdFac.setToys(toys);
                    Cmd cmd = cmdFac.create();
                    if (cmd != null) {
                        cmd.execute();
                    }
                } else if (option.equals("x")) {
                    System.out.println("Exit...");
                    System.exit(0);
                } else { // checking error
                    System.out.println("Please enter correct Option.");
                }

			} catch (Exception e) {
				System.out.println("*** " + e.getMessage());
			}
			System.out.println();
		}
	}
}