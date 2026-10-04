package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> semuaRequest = new LinkedList<>();
        LinkedList<String[]> dataBuku = new LinkedList<>();
        LinkedList<String[]> dataMember = new LinkedList<>();
        LinkedList<String[]> requestSukses = new LinkedList<>();
        Queue<String[]> prosesPeminjaman = new LinkedList<>();
        Stack<String[]> peminjamanGagal = new Stack<>();

        int maksimalPinjam = 2;

        dataBuku.add(new String[] { "Kalkulus", "2" });
        dataBuku.add(new String[] { "Fisika", "1" });
        dataBuku.add(new String[] { "Statistika", "2" });

        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (sc.hasNext()) {
            String nama = sc.next();
            String buku = sc.next();
            String[] mauPinjam = { nama, buku };
            semuaRequest.add(mauPinjam);

            boolean adaMember = false;
            for (String[] member : dataMember) {
                if (nama.equals(member[0])) {
                    adaMember = true;
                    break;
                }
            }

            if (!adaMember) {
                String[] memberBaru = { nama, "0" };
                dataMember.add(memberBaru);
            }
        }
        sc.close();

        for (String[] request : semuaRequest) {
            prosesPeminjaman.add(request);
        }

        while (!prosesPeminjaman.isEmpty()) {
            String[] currentRequest = prosesPeminjaman.poll();
            String nama = currentRequest[0];
            String judulBuku = currentRequest[1];

            String[] currentBuku = null;
            for (String[] buku : dataBuku) {
                if (buku[0].equals(judulBuku)) {
                    currentBuku = buku;
                    break;
                }
            }

            String[] currentMember = null;
            for (String[] member : dataMember) {
                if (member[0].equals(nama)) {
                    currentMember = member;
                    break;
                }
            }

            int stok = Integer.parseInt(currentBuku[1]);
            int jumlahPinjam = Integer.parseInt(currentMember[1]);

            if (stok > 0 && jumlahPinjam < maksimalPinjam) {
                currentBuku[1] = String.valueOf(stok - 1);
                currentMember[1] = String.valueOf(jumlahPinjam + 1);
                requestSukses.add(currentRequest);
            } else {
                peminjamanGagal.push(currentRequest);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] req : requestSukses) {
            System.out.println(req[0] + " " + req[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Book Stock ===");
        for (String[] buku : dataBuku) {
            System.out.println(buku[0] + " : " + buku[1]);
        }

        System.out.println();
        System.out.println("=== Failed Requests ===");
        while (!peminjamanGagal.isEmpty()) {
            String[] reqGagal = peminjamanGagal.pop();
            System.out.println(reqGagal[0] + " " + reqGagal[1]);
        }
    }
}