package algorithm;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class num53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int ans = nums[0], temp = nums[0];
        for (int i = 1; i < len; i++) {
            temp = temp < 0 ? nums[i] : temp + nums[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
