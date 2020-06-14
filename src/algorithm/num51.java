package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class num51 {

    List<List<String>> ans = new ArrayList<>();
    String empty = "";

    public List<List<String>> solveNQueens(int n) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++) {
            builder.append('.');
        }
        empty = builder.toString();
        solveNQueens(new ArrayList<>(n), 0, n);
        return ans;
    }

    public void solveNQueens(List<String> path, int p,int n) {
        // 遍历到了最后
        if(p == n) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < n; i++) {
            // 这一列合法
            if(isValid(path, p, i, n)) {
                path.add(empty.substring(0, i) + 'Q' + empty.substring(i + 1));
                solveNQueens(path, p + 1, n);
                path.remove(p);
            }
        }
    }

    public boolean isValid(List<String> path, int row, int col, int n) {
        int len = path.size();
        // 同一列
        for(int i = 0; i < len; i++) {
            if(path.get(i).charAt(col) == 'Q') {return false;}
        }
        // 左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (path.get(i).charAt(j) == 'Q') {return false;}
        }
        // 右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (path.get(i).charAt(j) == 'Q') {return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        num51 num51 = new num51();
        for (List<String> list : num51.solveNQueens(8)) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("下一行");
        }
    }

}
