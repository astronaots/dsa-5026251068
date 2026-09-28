package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> semuaRequest = new LinkedList<>();
        LinkedList<String[]> dataBuku = new LinkedList<>();
        LinkedList<String[]> dataPeminjaman = new LinkedList<>();
        Queue<String[]> prosesPeminjaman = new LinkedList<>();
        Stack<String[]> peminjamanGagal = new Stack<>();
        
        int maksimalPinjam = 2;

        Scanner sc =  new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (sc.hasNext()) {
            String nama = sc.next();
            String buku = sc.next();
            String[] mauPinjam = {nama, buku};
            semuaRequest.add(mauPinjam);

            String[] dataBukuSkrg = {buku, "0"};
            dataBuku.add(dataBukuSkrg);

            boolean adaMember = false;
            for (String[] member : dataPeminjaman) {
                    if (nama.equals(member[0])){
                    adaMember = true;
                    break;
                } 
            }
            
            if (adaMember == false) {
                String[] memberPinjam = {nama, "0"};
                dataPeminjaman.add(memberPinjam);
            }

        }

        prosesPeminjaman.add(semuaRequest);

        while (!prosesPeminjaman.isEmpty()) {
        String[] peminjamanBuku = prosesPeminjaman.poll();
        String[] memberSkrg = new String[0];
        String[] bukuSkrg = new String[1];

        for (String[] cust : dataCust) {
            if (cust[0].equals(currentTransaction[0])) {
            currentCust = cust;
        }

        }

        System.out.println("===Successfully Processed Requests ===");

        System.out.println("=== Remaining Book Stock ===");

        System.out.println("=== Failed Requests ===");
    }
}
