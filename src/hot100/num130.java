package hot100;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * @author qian
 * @date 2020/1/28 9:27
 */
public class num130 {

    public void solve(char[][] board) {
        int m = board.length, n = 0;
        if (m == 0) {return;}
        n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                visited[0][j] = true;
                extend(board, visited, 0, j, m, n);
            }

            if (board[m - 1][j] == 'O') {
                visited[m - 1][j] = true;
                extend(board, visited, m - 1, j, m, n);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                visited[i][0] = true;
                extend(board, visited, i, 0, m, n);
            }

            if (board[i][n - 1] == 'O') {
                visited[i][n - 1] = true;
                extend(board, visited, i, n - 1, m, n);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j]) { board[i][j] = 'X'; }
            }
        }
    }

    private void extend(char[][] board, boolean[][] visited, int i, int j, int m, int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(i, j));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            // 上
            if (x - 1 >= 0 && board[x - 1][y] == 'O' && !visited[x - 1][y]) {
                visited[x - 1][y] = true;
                queue.offer(new Pair<>(x - 1, y));
            }
            // 右
            if (y + 1 < n && board[x][y + 1] == 'O' && !visited[x][y + 1]) {
                visited[x][y + 1] = true;
                queue.offer(new Pair<>(x, y + 1));
            }
            // 下
            if (x + 1 < m && board[x + 1][y] == 'O' && !visited[x + 1][y]) {
                visited[x + 1][y] = true;
                queue.offer(new Pair<>(x + 1, y));
            }
            // 左
            if (y - 1 >= 0 && board[x][y - 1] == 'O' && !visited[x][y - 1]) {
                visited[x][y - 1] = true;
                queue.offer(new Pair<>(x, y - 1));
            }

        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

        num130 a = new num130();

        a.solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println("");
        }
    }
}
