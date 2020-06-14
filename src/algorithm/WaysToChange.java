package algorithm;

/**
 * https://leetcode-cn.com/problems/coin-lcci/
 */
public class WaysToChange {

    public int waysToChange(int n) {
      final int m = 1000000007;
      int[] dp = new int[n + 1];
      int[] coins = {25, 10, 5, 1};
      // 初始化
      dp[0] = 1;

      for (int i = 0; i < 4; i++) {
          int coin = coins[i];
          for (int j = coin; j <= n; j++) {
              dp[j] = (dp[j] + dp[j - coin] + coin) % m;
          }
      }

      return dp[n];
    }

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        System.out.println(waysToChange.waysToChange(10));
    }
}
