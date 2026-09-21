package lw01.unguided;

import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream is = Main.class.getResourceAsStream("rentals.txt");
        if (is == null) {
            System.err.println("File 'rentals.txt' not found in classpath.");
            return;
        }

        try (Scanner sc = new Scanner(is)) {

        int n = sc.nextInt();
        Rental[] rentals = new Rental[n];
        int currentindex = 0;

            while (n-- > 0) {
                String jenis = sc.next();
                String id = sc.next();
                int days = sc.nextInt();
                int unit = sc.nextInt();

                if (jenis.equals("LAPTOP")) {
                    Rental laptop = new LaptopRental(id, days);
                    rentals[currentindex] = laptop;
                    currentindex++;

                } else {
                    Rental projector = new ProjectorRental(id, days);
                    rentals[currentindex] = projector;
                    currentindex++;

                }
            }

            for (Rental print : rentals) {
            System.out.println(print.summary());
        }
        
        }
    }
}

