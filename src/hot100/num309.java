package hot100;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 *
 * 时间复杂度为O(n)的题解https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/ji-yu-zhuang-tai-ji-de-dong-tai-gui-hua-geng-jia-t/
 */
public class num309 {

    /**
     * 使用dp做，时间复杂度是O(n * n)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length, max = 0;
        if (len < 2) {return max;}
        // 缓存数组
        int[] dp = new int[len];
        // 记录最大值，比如maxValue[i] 记录的是dp数组中从i~len的最大值
        int[] maxValue = new int[len];

        // 初始化
        max = maxValue[len - 2] = dp[len - 2] = prices[len - 1] < prices[len - 2] ? 0 : prices[len - 1] - prices[len - 2];
        for (int i = len - 3; i >= 0; i--){
           for (int j = i + 1; j < len; j++){
               if (prices[j] < prices[i]) {continue;}
               dp[i] = Math.max(dp[i], prices[j] - prices[i] + (j + 2 < len ? maxValue[j + 2] : 0));
           }
            maxValue[i] = Math.max(maxValue[i + 1], dp[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        num309 a = new num309();

        int[] nums = {1,2,3,0,2};
//        int[] nums = {2, 1};
//        int[] nums = {2, 1, 2, 0, 1};
//        int[] nums = {6,1,6,4,3,0,2};
//        int[] nums = {1,2,4};

        System.out.print(a.maxProfit(nums));
    }
}
