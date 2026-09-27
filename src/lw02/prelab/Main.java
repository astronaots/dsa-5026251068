package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> semuaTransaksi = new LinkedList<>();
        LinkedList<String[]> dataCust = new LinkedList<>();
        Queue<String[]> prosesTransaksi = new LinkedList<>();
        Stack<String[]> transaksiGagal = new Stack<>();

        Scanner sc =  new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (sc.hasNext()) {
            String nama = sc.next();
            String jenis = sc.next();
            String uang = sc.next();
            String[] transaksiSkrg = {nama, jenis, uang};
            semuaTransaksi.add(transaksiSkrg);
            
            boolean adaKen = false;
            for (String[] cust : dataCust) {
                if (transaksiSkrg[0].equals(cust[0])){
                    adaKen = true;
                    break;
                } 
            }
            
            if (adaKen == false) {
                String[] custSkrg = {nama, "0"};
                dataCust.add(custSkrg);
            }
        }

        for (String[] transactionData : semuaTransaksi) {
            prosesTransaksi.add(transactionData);
        }

        while (!prosesTransaksi.isEmpty()) {
            String[] currentTransaction = prosesTransaksi.poll();
            String[] currentCust = new String[2];

            for (String[] cust : dataCust) {
                if (cust[0].equals(currentTransaction[0])) {
                    currentCust = cust;
                }
            }

            int total = 0;

            if (currentTransaction[1].equalsIgnoreCase("DEPOSIT")) {
                total = Integer.parseInt(currentCust[1]) +
                        Integer.parseInt(currentTransaction[2]);

            } else if (currentTransaction[1].equalsIgnoreCase("WITHDRAW")) {
                total = Integer.parseInt(currentCust[1]) -
                        Integer.parseInt(currentTransaction[2]);
            }

            if (total < 0) {
                transaksiGagal.add(currentTransaction);
            } else {
                currentCust[1] = String.valueOf(total);
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] custToPrint : dataCust) {
            System.out.println(custToPrint[0] + ": " + custToPrint[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!transaksiGagal.isEmpty()) {
            String[] transactionsToPrint = transaksiGagal.pop();
            System.out.println(transactionsToPrint[0] + " " + transactionsToPrint[1] + " " + transactionsToPrint[2]);
        }
    }
    
}
