package hot100;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author qian
 * @date 2020/1/21 17:00
 */
public class num122 {

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {

        int len = prices.length;
        int[] dp = new int[len + 1];

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] >= prices[i]) {
                    dp[i] = Math.max(dp[i], prices[j] - prices[i] + dp[j + 1]);
                }
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }

        return dp[0];
    }

    /**
     * 峰谷法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int i = 0, len = prices.length;
        int valley = 0, peak = 0;
        int maxprofit = 0;

        while (i < len - 1) {
            // 找到谷底
            while (i < len - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 找到峰顶
            while (i < len - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }

        return maxprofit;
    }

    public static void main(String[] args) {
        num122 a = new num122();
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.print(a.maxProfit(prices));
    }
}
