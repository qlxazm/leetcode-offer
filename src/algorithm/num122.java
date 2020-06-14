package algorithm;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class num122 {

    /**
     * 波峰时卖出，波谷时买入
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0, len = prices.length;
        if (len > 1) {
            int i = 1;
            while (i < len) {
                while (i < len && prices[i] <= prices[i - 1]) {
                    i++;
                }
                if (i == len) {break;}
                int valley = prices[i - 1];
                // 找到波峰
                while (i < len && prices[i] > prices[i - 1]) {
                    i++;
                }
                ans += prices[i - 1] - valley;
            }
        }
        return ans;
    }
}
