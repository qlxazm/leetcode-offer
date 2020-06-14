package other;

/**
 *https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean ans = false;

        int m = matrix.length;
        if (m == 0) {return ans;}
        int n = matrix[0].length;
        if (n == 0) {return ans;}

        int i = m - 1, j = 0;
        while (i >= 0 && j < n && !ans) {
            if (matrix[i][j] == target) {
                ans = true;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return ans;
    }
}
