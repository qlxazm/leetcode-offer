package algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class num189 {

    public void rotate(int[] nums, int k) {
        int i = 0, len = nums.length, last = 0;
        while (k > 0) {
            last = nums[len - 1];
            for (i = len - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = last;
            k--;
        }
    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length, half = len / 2, n = 0;
        if (len < 2) {return;}
        while (k > 0) {
            n = Math.min(k, half);
            // 执行翻转
            int i = n - 1, j = len - 1, tmp = 0;
            while (i >= 0) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i--;
                j--;
            }
            revese(nums, len - n, len - 1);
            revese(nums, n, len - n - 1);
            revese(nums, n, len - 1);

            k -= half;
        }
    }

    public void revese(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        num189 num189 = new num189();
        num189.rotate1(nums, 3);
    }
}
