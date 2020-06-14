package hot100;

import java.util.concurrent.*;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class num55_1 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = nums[i]; j > 0 && !dp[i]; j--) {
                dp[i] = (i + j) >= (len - 1) || dp[i + j];
            }
        }

        return dp[0];
    }

    /**
     * dfs超时
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        return (nums.length == 1 && nums[0] == 0) || dfs(nums, 0);
    }
    public boolean dfs(int[] nums, int k) {
        for (int i = 1; i <= nums[k]; i++) {
            if ((k + i) >= nums.length - 1 || dfs(nums, k + i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        num55_1 num55_1 = new num55_1();
        num55_1.canJump1(nums);
    }
}
