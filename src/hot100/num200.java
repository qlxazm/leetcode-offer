package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class num200 {

    /**
     * 并查集
     */
    private int[] buffer = null;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {return 0;}
        int n = grid[0].length;
        int i, j, len = m * n;
        // 初始化并查集
        buffer = new int[len];
        for (i = 0; i < len; i++) {buffer[i] = i;}

        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == '0'){continue;}
                // 上、右、下、左分别检查
                int[] positions = {i * n + j, -1, -1, -1, -1};
                boolean noSelf = false;
                if (i - 1 >= 0 && grid[i - 1][j] == '1'){
                    positions[1] = (i - 1) * n + j;
                    noSelf = true;
                }
                if (j + 1 < n && grid[i][j + 1] == '1'){
                    positions[2] = i * n + j + 1;
                    noSelf = true;
                }
                if (i + 1 < m && grid[i + 1][j] == '1') {
                    positions[3] = (i + 1) * n + j;
                    noSelf = true;
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    positions[4] = i * n + j - 1;
                    noSelf = true;
                }
                if (noSelf) {
                    join(positions);
                }
            }
        }

        // 统计并查集中集合的个数
        int result = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                int index = i * n + j;
                if (buffer[index] == index && grid[i][j] == '1') {
                    result++;
                }
            }
        }

        return result;
    }

    /**
     * 将b加入到a中,并返回新形成的集合
     * @param a
     * @param b
     * @return
     */
    private int join(int a, int b) {
        return buffer[b] = find(a);
    }

    private int find(int a) {
        if (a != buffer[a]) {
            buffer[a] = find(buffer[a]);
        }
        return buffer[a];
    }

    private void join(int[] args) {
        int root = args[0];
        for (int i = 1, len = args.length; i < len; i++) {
            if (args[i] == -1) {continue;}
            root = join(args[i], root);
        }
    }


    public static void main(String[] args) {
        num200 a = new num200();
        /*char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };*/
        /*char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };*/
        char[][] grid = {
                {'1','0','1','1','1'},
                {'1','0','1','0','1'},
                {'1','1','1','0','1'}
        };
        System.out.print(a.numIslands(grid));
    }
}
