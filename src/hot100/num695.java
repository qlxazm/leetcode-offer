package hot100;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 */
public class num695 {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    /**
     * 宽度优先搜索
     * @param grid
     * @param x
     * @param y
     * @return
     */
    private int bfs(int[][] grid, int x, int y) {
        int ans = 0;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

        // 初始化
        queue.push(new Pair<>(x, y));
        grid[x][y] = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int i = pair.getKey(), j = pair.getValue();
            ans++;
            // 上
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 0;
                queue.push(new Pair<>(i - 1, j));
            }
            // 右
            if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 0;
                queue.push(new Pair<>(i, j + 1));
            }
            // 下
            if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 0;
                queue.push(new Pair<>(i + 1, j));
            }
            // 左
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 0;
                queue.push(new Pair<>(i, j - 1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        num695 a = new num695();
        System.out.println(a.maxAreaOfIsland(grid));
    }
}
