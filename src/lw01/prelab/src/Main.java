import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));

         List<PrintJob> listPrint = new ArrayList<>();

         int n = 5;

         while (n-- > 0) {
            String line = sc.nextLine();
            String[] dataPrint = line.split(" ");

            if (dataPrint[0].equals("MONO")) {
                PrintJob mono = new MonoPrint(dataPrint[1], Integer.parseInt(dataPrint[2]));
                listPrint.add(mono);
            } else {
                PrintJob colour = new ColourPrint(dataPrint[1], Integer.parseInt(dataPrint[2]));
                listPrint.add(colour);
            }
         }
        
         for (PrintJob print : listPrint) {
             System.out.println(print.summary());
         }
    }
}
