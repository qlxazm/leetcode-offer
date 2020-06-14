package algorithm;

import java.util.Scanner;

/**
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q > 0) {
            int n = scanner.nextInt();
            int[][] A = new int[n][2];
            int[][] B = new int[n][2];

            for (int i = 0; i < n; i++) {
                A[i][0] = scanner.nextInt();
                A[i][1] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                B[i][0] = scanner.nextInt();
                B[i][1] = scanner.nextInt();
            }

            double ans = Double.MAX_VALUE, temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp = (A[i][0] - B[j][0]) * (A[i][0] - B[j][0]) + (A[i][1] - B[j][1]) * (A[i][1] - B[j][1]);
                    temp = Math.sqrt(temp);
                    ans = Math.min(ans, temp);
                }
            }
            System.out.println(String.format("%.3f", ans));

            q--;
        }
    }
}
