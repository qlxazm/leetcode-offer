package hot100;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class num62 {
    private int paths = 0;
    public int uniquePaths(int m, int n) {
        //n行 m列
        int[][]  dp = new int[n][m];
        int i, j;

        for (i = 0; i < m; i++){ dp[n - 1][i] = 1;}
        for (i = 0; i < n; i++) { dp[i][m - 1] = 1;}

        for (i = n - 2; i >= 0; i--){
            for (j = m - 2; j >= 0; j--){
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public void findPath(int x1, int y1, int X, int Y) {
        if (x1 > X || y1 > Y){return;}

        if (x1 == X && y1 == Y) {
            paths++;
            return;
        }
        //向下走一步
        findPath(x1, y1 + 1, X, Y);
        //向右走一步
        findPath(x1 + 1, y1, X, Y);
    }

    public static void main(String[] args) {
        num62 a = new num62();
        System.out.println(a.uniquePaths(1, 1));
    }
}
