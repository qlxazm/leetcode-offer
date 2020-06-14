package hot100;

import java.util.Arrays;

/**
 * 动态规划法：
 * https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class num85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n, maxarea = 0;
        if (m == 0) {return 0;}
        n = matrix[0].length;

        // 将left初始化为可能的最大值0，将right初始化为可能的最大值n
        int[] height = new int[n], left = new int[n], right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < m; i++) {
            int currLeft = 0, currRight = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 根据上一次计算的上一行的高度，扩展高度
                    height[j]++;

                    // 根据上一次计算出的left数组，更新left
                    left[j] = Math.max(left[j], currLeft);
                }else {
                    height[j] = 0;

                    currLeft = j + 1;
                    left[j] = 0;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                // 根据上一次计算出的right数组，更新right
                if (matrix[i][j] == '1'){
                    right[j] = Math.min(right[j], currRight);
                }else {
                    currRight = j;
                    right[j] = n;
                }
            }

            for (int j = 0; j < n; j++) {
                maxarea = Math.max(height[j] * (right[j] - left[j]), maxarea);
            }
        }

        return maxarea;
    }

    public static void main(String[] args) {
        num85 a = new num85();
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(a.maximalRectangle(matrix));
    }
}
