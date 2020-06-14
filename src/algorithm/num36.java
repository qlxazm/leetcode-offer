package algorithm;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class num36 {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {continue;}
                int index = board[i][j] - '0';
                if (row[i][index]) {return false;}
                row[i][index] = true;
                if (col[j][index]) {return false;}
                col[j][index] = true;
                if (box[(i / 3) * 3 + j / 3][index]) {return false;}
                box[(i / 3) * 3 + j / 3][index] = true;
            }
        }

        return true;
    }

}
