package algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class num322 {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        // 初始化
        dp[0] = 0;
        int coin = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if ((coin = coins[j]) > i) {break;}
                if (dp[i - coin] >= 0) {
                    dp[i] = dp[i] == -1 ? dp[i - coin] + 1 : Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount];
    }

}
