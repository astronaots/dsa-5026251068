package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> listEnroll = new HashMap<>();
        Set<String> urutanCourse = new LinkedHashSet<>();
        List<String> cekHasil = new ArrayList<>();

        int gagal = 0;

        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        while (sc.hasNext()) {
            String keterangan = sc.next();
            String kodeCourse = sc.next();

            if (keterangan.equals("REGISTER")) {
                int jumlah = sc.nextInt();
                if (jumlah <= 0) {
                    gagal++;
                } else {
                    if (listEnroll.containsKey(kodeCourse)) {
                        int jumlahSkrg = listEnroll.get(kodeCourse);
                        listEnroll.put(kodeCourse, jumlahSkrg + jumlah);
                    } else {
                        urutanCourse.add(kodeCourse);
                        listEnroll.put(kodeCourse, jumlah);
                    }
                }
            } else if (keterangan.equals("WITHDRAW")) {
                int jumlah = sc.nextInt();
                if (jumlah <= 0) {
                    gagal++;
                } else {
                    if (listEnroll.containsKey(kodeCourse)) {
                        int jumlahSkrg = listEnroll.get(kodeCourse);
                        if (jumlahSkrg >= jumlah) {
                            listEnroll.put(kodeCourse, jumlahSkrg - jumlah);
                        } else {
                            gagal++;
                        }
                    } else {
                        gagal++;
                    }
                }
            } else if (keterangan.equals("CHECK")) {
                if (listEnroll.containsKey(kodeCourse)) {
                    cekHasil.add(kodeCourse + ": " + listEnroll.get(kodeCourse) + " students");
                } else {
                    cekHasil.add(kodeCourse + ": Not found");
                }
            }
        }

        System.out.println("===== Enrollment Checks =====");
        for (int i = 0; i < cekHasil.size(); i++) {
            System.out.println(cekHasil.get(i));
        }

        System.out.println();

        System.out.println("===== Final Enrollment =====");
        for (String kodeCourse : urutanCourse) {
            System.out.println(kodeCourse + ": " + listEnroll.get(kodeCourse) + " students");
        }

        System.out.println();

        System.out.println("Rejected Operations: " + gagal);
    }
}
