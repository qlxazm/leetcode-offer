package algorithm;

/**
 * https://leetcode-cn.com/problems/largest-1-bordered-square/
 */
public class num1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int ans = 0, m, n;
        if ((m = grid.length) == 0 || (n = grid[0].length) == 0) {
            return ans;
        }

        // 水平方向上能到达的距离
        int[][] dpH = new int[m + 1][n + 1];
        // 垂直方向上能到达的距离
        int[][] dpV = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    if (i == 0 && j == 2) {
                        int b = 21221;
                    }
                    dpH[i][j] = dpH[i][j + 1] + 1;
                    dpV[i][j] = dpV[i + 1][j] + 1;
                    // 计算正方形
                    int a = Math.min(dpH[i][j], dpV[i][j]);
                    for (; a > 0; a--) {
                        if (dpV[i][j + a - 1] >= a && dpH[i + a - 1][j] >= a) {
                            ans = Math.max(ans, a * a);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,1},
                {1,0,1,1,1,0,1,1},
                {1,1,1,1,0,1,1,1},
                {1,0,1,0,0,1,1,1},
                {0,1,1,1,1,0,1,1}
        };

        num1139 num1139 = new num1139();
        System.out.println(num1139.largest1BorderedSquare(grid));
    }
}
