package algorithm;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 */
public class num213 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {return 0;}
        if (len == 1) {return nums[0];}
        if (len == 2) {return Math.max(nums[0], nums[1]);}
        return Math.max(maxProfit(0, len - 2, nums), maxProfit(1, len - 1, nums));
    }

    private int maxProfit(int start, int end, int[] nums) {

        int[] dp = {nums[start], Math.max(nums[start], nums[start + 1])};
        for (int i = start + 2; i <= end; i++) {
            int tmp = Math.max(dp[1], dp[0] + nums[i]);
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        num213 num213 = new num213();
        int[] nums = {1, 3, 1, 3, 100};
        System.out.println(num213.rob(nums));
    }

}
