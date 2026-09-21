import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream is = Main.class.getResourceAsStream("jobs.txt");
        if (is == null) {
            System.err.println("File 'jobs.txt' not found in classpath.");
            return;
        }

        List<PrintJob> listPrint = new ArrayList<>();

        int n = 5;
        try (Scanner sc = new Scanner(is)) {

            while (n-- > 0) {
                String jenis = sc.next();
                String id = sc.next();
                int jumlahPages = sc.nextInt();

                if (jenis.equals("MONO")) {
                    PrintJob mono = new MonoPrint(id, jumlahPages);
                    listPrint.add(mono);
                } else {
                    PrintJob colour = new ColourPrint(id, jumlahPages);
                    listPrint.add(colour);
                }
            }
        }
        for (PrintJob print : listPrint) {
            System.out.println(print.summary());
        }
    }
}
