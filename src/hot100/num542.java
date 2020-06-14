package hot100;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 */
public class num542 {


    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
    boolean[][] visited;

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Pair<>(i, j));
                    visited[i][j] = true;
                }
            }
        }
        return wfs(matrix, n, m);
    }

    /**
     * 及时终止广度优先搜素
     */
    public int[][] wfs(int[][] matrix, int n, int m) {

        int[][] buffer = new int[n][m];

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int p = pair.getKey(), q = pair.getValue();
            // 上
            if (p - 1 >= 0 && !visited[p - 1][q]) {
                visited[p - 1][q] = true;
                buffer[p - 1][q] = buffer[p][q] + 1;
                queue.offer(new Pair<>(p - 1, q));
            }
            // 右
            if (q + 1 < m && !visited[p][q + 1]) {
                visited[p][q + 1] = true;
                buffer[p][q + 1] = buffer[p][q] + 1;
                queue.offer(new Pair<>(p, q + 1));
            }
            // 下
            if (p + 1 < n && !visited[p + 1][q]) {
                visited[p + 1][q] = true;
                buffer[p + 1][q] = buffer[p][q] + 1;
                queue.offer(new Pair<>(p + 1, q));
            }
            // 左
            if (q - 1 >= 0 && !visited[p][q - 1]) {
                visited[p][q - 1] = true;
                buffer[p][q - 1] = buffer[p][q] + 1;
                queue.offer(new Pair<>(p, q - 1));
            }
        }
        return buffer;
    }


    public int[][] updateMatrix1(int[][] matrix) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = matrix.length, m = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[n][m];
        // 先将与0紧临的加入队列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < m
                                && matrix[x][y] == 1 && ans[x][y] == 0) {
                            ans[x][y] = 1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        // 开始扩展
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = point[0] + dx[k], y = point[1] + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < m
                        && matrix[x][y] == 1 && ans[x][y] == 0) {
                    ans[x][y] = ans[point[0]][point[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        num542 num542 = new num542();
        int[][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        for (int[] nums : num542.updateMatrix(matrix)) {
            for (int num : nums) {
                System.out.print(num + ",");
            }
            System.out.println("");
        }
    }
}
