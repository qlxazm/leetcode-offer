package hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class num221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {return 0;}
        int n = matrix[0].length;

        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        // 初始化left、right，left被初始化为全为0，right被初始化为全为n
        Arrays.fill(right, n);
        int max = 0;
        for (int i = 0; i < m; i++) {
            // 向上探测，更新高度
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }

            // 向左探测，更新左侧
            int currLeft = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currLeft);
                }else {
                    left[j] = 0;
                    currLeft = j + 1;
                }
            }

            // 向右探测，更新右测
            int currRight = n;
            for (int j = n - 1; j >= 0; j--){
                if (matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], currRight);
                }else{
                    right[j] = n;
                    currRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {continue;}
                int h = Math.min(height[j], right[j] - left[j]);
                max = Math.max(max, h * h);
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
