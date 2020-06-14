package algorithm;


import java.util.Scanner;

/**
 *
 */
public class MaxCoins {
    public int ans = 0;

    public void dfs(int[][] grid, int i, int j, int sum, int N) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return;
        }
        ans = Math.max(ans, sum + grid[i][j]);
        dfs(grid, i + 1, j, sum + grid[i][j], N);
        dfs(grid, i + 1, j + 1, sum + grid[i][j], N);
    }

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

        MaxCoins maxCoins = new MaxCoins();
        maxCoins.dfs(grid, 0, 0, 0, N);
        System.out.println(maxCoins.ans);
    }
}
