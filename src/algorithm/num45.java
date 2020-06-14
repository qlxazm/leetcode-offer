package algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class num45 {

    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, -1);
        dp[len - 1] = 0;
        int i = len - 2;

        while (i >= 0) {
            for (int j = 1; j <= nums[i]; j++) {
                if (j + i < len && dp[j + i] != -1) {
                    dp[i] = dp[i] == -1 ? dp[j + i] + 1 : Math.min(dp[j + i] + 1, dp[i]);
                }
            }
            i--;
        }

        return dp[0];
    }

    public int jump1(int[] nums) {
        int i = 0, j = 1, max = nums[1], len = nums.length;
        int ans = 0;
        while (i < len) {
            for (int k = 1; k <= nums[i]; k++) {
                if (k + i < len) {
                    return ans + 1;
                }

                if (nums[k + i] > max) {
                    j = k + i;
                    max = nums[k + i];
                }
            }
            ans++;
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        num45 num45 = new num45();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(num45.jump1(nums));
    }

}
