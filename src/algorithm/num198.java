package algorithm;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class num198 {

    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) {return 0;}
        int[] dp = new int[2];
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            int tmp = dp[0];
            dp[0] = dp[1];
            dp[1] = Math.max(tmp + nums[i - 1], dp[1]);
        }
        return dp[1];
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int ans = 0;
        if (len == 0) {return ans;}

        int[][] dp = new int[2][len];
        // 第一行代表不盗窃，第二行代表盗窃房屋
        dp[0][len - 1] = 0;
        dp[1][len - 1] = nums[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            //不盗窃第i号房屋
            for (int j = i + 1; j < len; j++) {
                dp[0][i] = Math.max(dp[0][i], dp[0][j]);
                dp[0][i] = Math.max(dp[0][i], dp[1][j]);
            }
            //盗窃第i号房屋
            for (int j = i + 2; j < len; j++) {
                dp[1][i] = Math.max(dp[1][i], dp[0][j]);
                dp[1][i] = Math.max(dp[1][i], dp[1][j]);
            }
            dp[1][i] += nums[i];
        }

        return Math.max(dp[0][0], dp[1][0]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        num198 num198 = new num198();
        System.out.println(num198.rob(nums));
    }
}
