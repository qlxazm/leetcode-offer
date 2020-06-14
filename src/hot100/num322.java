package hot100;


import java.util.Arrays;

/**
 * 完全背包问题
 * https://leetcode-cn.com/problems/coin-change/
 * @author qian
 * @date 2020/1/15 11:25
 */
public class num322 {

    private Integer[][] buffer;

    /*public int coinChange(int[] coins, int amount) {
        buffer = new Integer[coins.length][amount + 1];
        return coinChange(coins.length - 1, coins, amount);
    }*/


    /**
     * 方法1：回溯法
     * @param coinIndex  coins数组的索引
     * @param coins      硬币面值数组
     * @param amount
     * @return
     */
    public int coinChange(int coinIndex, int[] coins, int amount) {
        int ans = Integer.MAX_VALUE;

        if (amount == 0) {
            ans = 0;
        } else if (coinIndex >= 0 && amount > 0) {
            if (buffer[coinIndex][amount] != null) {
                ans = buffer[coinIndex][amount];
            }else {
                for (int k = 0; k * coins[coinIndex] <= amount; k++) {
                    int temp = coinChange(coinIndex - 1, coins, amount - k * coins[coinIndex]);
                    if (temp != -1) {
                        ans = Math.min(ans, temp + k);
                    }
                }
            }
        }

        ans = (ans == Integer.MAX_VALUE) ? -1 : ans;

        if (coinIndex >= 0 && amount >= 0) {
            buffer[coinIndex][amount] = ans;
        }

        return ans;
    }


    /*public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        coinChange(coins, amount, dp);
        return dp[amount];
    }*/

    /**
     * 自上而下的递归遍历
     * @param coins
     * @param amount
     * @param dp        因为在递归过程中很多子问题计算了多次，所以使用缓存数组存下中间结果
     * @return
     */
    public int coinChange(int[] coins, int amount, Integer[] dp) {

        int ans = Integer.MAX_VALUE;
        if (amount < 0) {
            ans = -1;
        } else if (amount == 0) {
            ans = 0;
        } else {
            if (dp[amount] != null) {
                ans = dp[amount];
            }else {
                for (int i = 0, len = coins.length; i < len; i++) {
                    int temp = coinChange(coins, amount - coins[i], dp);
                    if (temp >= 0) {
                        ans = Math.min(temp + 1, ans);
                    }
                }
                ans = ans == Integer.MAX_VALUE ? -1 : ans;
            }
        }

        if (amount >= 0) {dp[amount] = ans;}

        return ans;
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 初始化
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0, len = coins.length; j < len; j++) {
                int coin = coins[j];
                if (i >= coin && dp[i - coin] >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
            dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
        }

        return dp[amount];
    }

        public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amouns = 6249;

       /* int[] coins = {346,29,395,188,155,109};
        int amouns = 9401;*/

        /*int[] coins = {1, 2, 5};
        int amouns = 11;*/

        num322 a = new num322();

        System.out.println(a.coinChange(coins, amouns));
    }
}
