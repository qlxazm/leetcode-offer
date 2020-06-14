package algorithm;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class num283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0, j = 0, count = 0;
        for (; j < len; j++) {
            nums[i] = nums[j];
            if (nums[j] != 0) { i++; }
        }
        for (; i < len; i++) {
            nums[i] = 0;
        }

    }


}
