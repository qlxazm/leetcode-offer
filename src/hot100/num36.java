package hot100;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 * @author qian
 * @date 2020/1/18 9:24
 */
public class num36 {
    /*public boolean isValidSudoku(char[][] board) {
        boolean ans = true;

        // 先按行遍历
        for (int i = 0; i < 9; i++) {
            ans = ans && isValidSudoku(board, i, i, 0, 8);
            if (!ans) {return ans;}
        }

        // 在按照列遍历
        for (int i = 0; i < 9; i++) {
            ans = ans && isValidSudoku(board, 0, 8, i, i);
            if (!ans) {return ans;}
        }

        // 按照块遍历
        for (int i = 0; i < 9; i++) {
            ans = ans && isValidSudoku(board, (i / 3) * 3, (i / 3) * 3 + 2, (i % 3) * 3, (i % 3) * 3 + 2);
            if (!ans) {return ans;}
        }

        return true;
    }
*/
    private boolean isValidSudoku(char[][] board, int xLower, int xHeight, int yLower, int yHeight) {
        boolean[] buffer = new boolean[10];
        for (; xLower <= xHeight; xLower++) {
            for (int j = yLower; j <= yHeight; j++) {
                if (board[xLower][j] == '.') {continue;}
                int index = board[xLower][j] - '0';
                if (buffer[index]) {return false;}
                buffer[index] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        final int CAPACITY = 9;

        boolean[][] rowsBuffer = new boolean[CAPACITY][CAPACITY + 1];
        boolean[][] columnsBuffer = new boolean[CAPACITY][CAPACITY + 1];
        boolean[][] boxBuffer = new boolean[CAPACITY][CAPACITY + 1];

        for (int i = 0; i < CAPACITY; i++){
            for (int j = 0; j < CAPACITY; j++) {
                if (board[i][j] == '.') {continue;}
                int index = board[i][j] - '0';

                if (rowsBuffer[i][index] || columnsBuffer[j][index] || boxBuffer[(i / 3) * 3 + j / 3][index]) {return false;}
                rowsBuffer[i][index] = true;
                columnsBuffer[j][index] = true;
                boxBuffer[(i / 3) * 3 + j / 3][index] = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        num36 a = new num36();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        /*char[][] board = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}

        };*/


        System.out.println(a.isValidSudoku(board));
    }
}
