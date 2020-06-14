package hot100;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class num64 {
    public int minPathSum(int[][] grid) {
        //n行 m列
        int n = grid.length, m = grid[0].length, i, j, sum;
        int[][]  dp = new int[n][m];


        for (sum = 0, i = m - 1; i >= 0; i--){
            sum += grid[n - 1][i];
            dp[n - 1][i] = sum;
        }
        for (sum = 0, i = n - 1; i >= 0; i--) {
            sum += grid[i][m - 1];
            dp[i][m - 1] = sum;
        }

        for (i = n - 2; i >= 0; i--){
            for (j = m - 2; j >= 0; j--){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        num64 a = new num64();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(a.minPathSum(grid));
    }
}
