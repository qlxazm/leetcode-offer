package algorithm;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class num29 {

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {return new int[0];}
        int n = matrix[0].length;
        int len = m * n;
        int[] ans = new int[len];
        int k = 0;

        // 行的上下界
        int rowLower = 0, rowHigh = m - 1;
        // 列的上下界
        int colLower = 0, colHigh = n - 1;

        while (rowLower <= rowHigh) {
            int j = colLower;
            while (k < len && j <= colHigh) {
                ans[k++] = matrix[rowLower][j++];
            }

            j = rowLower + 1;
            while (k < len && j <= rowHigh) {
                ans[k++] = matrix[j++][colHigh];
            }

            j = colHigh - 1;
            while (k < len && j >= colLower) {
                ans[k++] = matrix[rowHigh][j--];
            }

            j = rowHigh - 1;
            while (k < len && j > rowLower) {
                ans[k++] = matrix[j--][colLower];
            }

            rowLower++;
            rowHigh--;
            colLower++;
            colHigh--;
        }

        return ans;
    }
}
