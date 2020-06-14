package interview_questions;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * 部分排序
 */
public class SubSort {
    public int[] subSort(int[] array) {
        int[] ans = {-1, -1};
        int i = 0, j = array.length - 1;
        // 寻找原始的失序数组
        while (i < j && array[i] <= array[i + 1]) { i++; }
        // 提前结束
        if (i >= j) {return ans;}
        while (j > 0 && array[j - 1] <= array[j]) { j--; }
        int k = i + 1, max = array[i], min = array[i];
        while (k <= j) {
            max = Math.max(max, array[k]);
            min = Math.min(min, array[k]);
            k++;
        }
        // 扩展找答案
        while (i > 0 && array[i - 1] > min) { i--; }
        while (j < array.length - 1 && array[j + 1] < max ) { j++; }
        ans[0] = i;
        ans[1] = j;
        return ans;
    }
}
