package algorithm;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class num200 {

    public int numIslands(char[][] grid) {
        int ans = 0;
        int m = grid.length;
        if (m > 0) {
            int n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        ans++;
                        grid[i][j] = '0';
                        dfs(grid, i, j, m, n);
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int row, int col, int m, int n) {
        int[] xd = {-1, 0, 1, 0};
        int[] yd = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int x = row + xd[i], y = col + yd[i];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                grid[x][y] = '0';
                dfs(grid, x, y, m, n);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        num200 num200 = new num200();
        System.out.println(num200.numIslands(grid));
    }
}
