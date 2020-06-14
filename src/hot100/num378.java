package hot100;

/**
 *  https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 *  这里要求的是第K小元素
 *  第K小不需要去重
 *  第K个需要去重
 *
 * @author qian
 * @date 2020/1/11 14:38
 */
public class num378 {

    /**
     * 方法1：二分查找法
     * @param matrix
     * @param k
     * @return
     */
   /* public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) {
            n = matrix[0].length;
        }
        // 左上角的是最小值
        int left = matrix[0][0];
        // 右下角的是最大值
        int right = matrix[m - 1][n - 1];
        *//*
        * 可以肯定第K小的数肯定在闭区间[left, right]内，在==保证第K小的值一定在[left, right]区间内==的条件下
        * 不断缩小这个区间的长度，直到区间长度为1，也就是left=right时就能得到解
        * *//*
        int middle;
        while (left < right) {
            middle = (left + right) / 2;
            // 在数组中找到小于等于middle的元素的个数
            int count = findNumOfNotLargeMiddle(matrix, middle, m, n);
            if (count < k) {
                // 如果count小于k，第K小的数字肯定不在闭区间[left, middle]内，肯定在[middle + 1, right]内，所以更新left
                left = middle + 1;
            }else {
                right = middle;
            }
        }
        return left;
    }
*/
    /**
     * 在matrix数组中查找小于等于middle的元素的个数
     * @param matrix
     * @param middle
     * @param m
     * @param n
     * @return
     */
    private int findNumOfNotLargeMiddle(int[][] matrix, int middle, int m, int n) {
        int count = 0;
        // 按列找，从下到上，找到第一个小于等于middle的元素，就换下一列
        int j = 0, i;
        while (j < n) {
            // 优化一下，跳过不必要的行
            if (matrix[m - 1][j] > middle) {m--;}

            i = m - 1;
            while (i >= 0) {
                if (matrix[i][j] <= middle) {
                    count += i + 1;
                    break;
                }
                i--;
            }
            j++;
        }
        return count;
    }

    /**
     * 方法2：这是num4题目方法2的增强版本
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) {
            n = matrix[0].length;
        }
        // 记录每一行的开始位置，默认是从0开始
        int[] startIndexs = new int[m];

        return 0;
    }

    private int getKth(final int[][] matrix, final int m, final int n, final int[] startIndexs, final int K) {

        // 寻找每一行的 K / m 位置的元素的最大值的索引
        int maxRowIndex = 0, diff = K / m, index;
        for (int i = 0; i < m; i++) {
            if ((index = startIndexs[i] + diff - 1) >= n) {continue;}
//            if (matrix[maxRowIndex][startIndexs[maxRowIndex] + di])
        }
        return 0;
    }

        public static void main(String[] args) {
        int[][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;

        num378 a = new num378();
        System.out.print(a.kthSmallest(matrix, k));
    }
}
