package algorithm;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {

        for (int i = 0, len = nums.length; i < len; i++) {
            int num = nums[i];
            if (num == i) {continue;}
            while (num != i) {
                if (num == nums[num]) {
                    return num;
                }
                int tmp = nums[i];
                nums[i] = nums[num];
                nums[num] = tmp;
                num = nums[i];
            }
        }

        return -1;
    }
}
