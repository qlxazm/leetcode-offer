package algorithm;

import java.util.Scanner;

/**
 */
public class MaxCoin1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] grid = new int[N][N];
        int i = 0, k = 0, j = 0;
        for (i = 0; i < N; i++) {
            for (j = 0; j <= k; j++) {
                grid[i][j] = scanner.nextInt();
            }
            k++;
        }

        int[][] buffer = new int[N][N];
        // 初始化
        for (i = 0; i < N; i++) {
            buffer[N - 1][i] = grid[N - 1][i];
        }

        k = N - 1;
        for (i = N - 2; i >= 0; i--) {
            for (j = 0; j < k; j++) {
                buffer[i][j] = Math.max(buffer[i][j], buffer[i + 1][j]);
                if (j + 1 <= k) {
                    buffer[i][j] = Math.max(buffer[i][j], buffer[i + 1][j + 1]);
                }
                buffer[i][j] += grid[i][j];
            }
            k--;
        }

        System.out.println(buffer[0][0]);
    }
}
