package algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/delete-and-earn/solution/ru-guo-ni-li-jie-liao-da-jia-jie-she-zhe-ti-ni-ken/
 */
public class num740 {

    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];
        int[] buffer = new int[max + 1];
        for (int num : nums) {
            buffer[num]++;
        }

        // 初始化
        dp[1] = buffer[1];
        dp[2] = Math.max(dp[1], buffer[2] * 2);
        for (int i = 3; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * buffer[i]);
        }

        return dp[max];
    }

}
