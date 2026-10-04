package lw03.prelab;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Problem 1
        List<String> lagu = new ArrayList<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (sc.hasNextLine()) {
            String lineTxt = sc.nextLine();

            String[] keterangan = lineTxt.split(" ", 2);
            String tugas = keterangan[0];

            if (tugas.equals("ADD")) {
                lagu.add(keterangan[1]);
            } else if (tugas.equals("INSERT")) {
                String[] splitIndex = keterangan[1].split(" ", 2);
                int index = Integer.parseInt(splitIndex[0]);
                lagu.add(index, splitIndex[1]);
            } else if (tugas.equals("REMOVE"))
                lagu.remove(keterangan[1]);
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + lagu.size());
        for (int i = 0; i < lagu.size(); i++) {
            System.out.println((i + 1) + ": " + lagu.get(i));
        }
        System.out.println();

        // Problem 2
        Set<String> peserta = new LinkedHashSet<>();
        int dataDuplikat = 0;

        sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (sc.hasNext()) {
            String nama = sc.next();

            for (String n : peserta) {
                if (n.equals(nama)) {
                    dataDuplikat++;
                }
            }
            
            peserta.add(nama);
        
        }

        System.out.println("==== Problem 2 ====");
        System.out.println("Unique participants: " + peserta.size());
        int jumlahPeserta = 1;
        for (String p : peserta) {
            System.out.println(jumlahPeserta + ". " + p);
            jumlahPeserta++;
        }

        System.out.println("Duplicate registrations: " + dataDuplikat);

        System.out.println();

        //Problem 3
        Map<String, Integer> inventory = new LinkedHashMap<>();

        sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        int transaksiGagal = 0;

        while (sc.hasNext()) {
            String transaksi = sc.next();
            String produk = sc.next();
            int jumlah = sc.nextInt();

            int produkAvail = 0;

            if (inventory.containsKey(produk)) {
                produkAvail = inventory.get(produk);
            }

            if (transaksi.equals("ADD")) {
                inventory.put(produk, produkAvail + jumlah);
            } else {
                if (jumlah > produkAvail) {
                    transaksiGagal++;
                } else {
                    inventory.put(produk, produkAvail - jumlah);
                }
            }
        }

        System.out.println("==== Problem 3 ====");
        inventory.forEach((namaProduk, total) -> {
        System.out.println(namaProduk + ": " + total);
        });
        
        System.out.println("Failed sales: " + transaksiGagal);
    }

}
