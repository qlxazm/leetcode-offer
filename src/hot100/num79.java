package hot100;

/**
 * https://leetcode-cn.com/problems/word-search/
 * 图的深度优先遍历
 */
public class num79 {
    public boolean exist(char[][] board, String word) {
        if (word.equals("")){return false;}
        char firstChar = word.charAt(0);
        int i, j, len, len1;
        for (i = 0, len = board.length; i < len; i++){
            for (j = 0, len1 = board[i].length; j < len1; j++){
                if (board[i][j] != firstChar) {continue;}
                if (depthFirst(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean depthFirst(char[][] board, int i, int j, int index, String word) {
        if (board[i][j] != word.charAt(index)){return false;}
        int n = board.length, m = board[0].length;
        if (index == word.length() - 1) {return board[i][j] != 0;}

        char buffer = board[i][j];
        //对于已经访问过的置访问标志
        board[i][j] = 0;

        //上 i - 1, j  下 i + 1, j   左 i, j - 1  右 i, j + 1
        if (i - 1 >= 0 && board[i - 1][j] != 0 && depthFirst(board, i - 1, j, index + 1, word)) {
            return true;
        }
        if (i + 1 < n && board[i + 1][j] != 0 && depthFirst(board, i + 1, j, index + 1, word)) {
            return true;
        }

        if (j - 1 >= 0 && board[i][j - 1] != 0 && depthFirst(board, i, j - 1, index + 1, word)) {
            return true;
        }

        if (j + 1 < m && board[i][j + 1] != 0 && depthFirst(board, i, j + 1, index + 1, word)) {
            return true;
        }
        board[i][j] = buffer;
        return false;
    }

    public static void main(String[] args) {
        num79 a = new num79();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
//        String word = "ABCCED";
//        String word = "SEE";
        String word = "ABCB";
        System.out.println(a.exist(board, word));
    }
}
