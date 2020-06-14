package hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class num300 {
   /* public int lengthOfLIS(int[] nums) {
        int len = nums.length, max = 0;
        int[] dp = new int[len];
        if (len > 0) {
            dp[len - 1] = max = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }*/

    public int lengthOfLIS(int[] nums) {
        int ans = 0, len = nums.length;
        if (len > 0) {
            int[] dp = new int[len + 1];
            // 初始化
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i + 1; j < len - dp[i]; j++) {
                    if (nums[j] > nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += 1;
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        num300 a = new num300();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.print(a.lengthOfLIS(nums));
    }
}
