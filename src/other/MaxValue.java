package other;

import java.util.Scanner;

/**
 */
public class MaxValue {


    private long max = 0;

    public void maxValue() {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = null;
        int T = scanner.nextInt();
        while (T > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // 读取数组
            matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            max = 0;
            System.out.println(getMaxValue(matrix, n, k));
            T--;
        }


    }

    public int getMaxValue(int[][] matrix, int n, int k) {
        dfs(matrix, 0, 0, n, k, matrix[0][0]);
        return 0;
    }


    public long dfs(int[][] matrix, int i, int j, int n, int k, long before) {
        int m = 0;
        long ans = before;
        // 上
        if (i - 1 >= 0) {
            m = 0;
            while (m < k && matrix[i - m][j] > matrix[i][j]) {
                m++;
                dfs(matrix, i - m, j, n, k, ans);
                ans += matrix[i - m][j];
            }
        }
        // 右
        if (j + 1 < n) {
            m = 0;
            while (m < k && matrix[i][j + m] > matrix[i][j]) {
                m++;
                dfs(matrix, i, j + m, n, k, ans);
            }
        }
        // 下
        if (i + 1 < n) {
            m = 0;
            while (m < k && matrix[i + m][j] > matrix[i][j]) {
                m++;
                dfs(matrix, i + m, j, n, k, ans);
            }
        }
        // 左
        if (j - 1 >= 0) {
            m = 0;
            while (m < k && matrix[i - m][j] > matrix[i][j]) {
                m++;
                dfs(matrix, i - m, j, n, k, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Main a = new Main();
    }
}
