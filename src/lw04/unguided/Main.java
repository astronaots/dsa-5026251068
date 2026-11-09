package lw04.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = sc.nextInt();
        int[] kartu = new int[n];
        for (int i = 0; i < n; i++) {
            kartu[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] requested = new int[m];
        for (int i = 0; i < m; i++) {
            requested[i] = sc.nextInt();
        }
        sc.close();

        sortKartu(kartu, 2);

        for (int i = 0; i < n; i++) {
            System.out.print(kartu[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int target = requested[i];
            int index = findCard(kartu, target);

            if (index != -1) {
                System.out.println(target + ": FOUND at index " + index);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
    }

    public static void sortKartu(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes && i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;

        }
    }

    public static int findCard(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
