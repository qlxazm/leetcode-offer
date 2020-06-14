package hot100;

/**
 * https://leetcode-cn.com/problems/house-robber/
 */
public class num198 {
    public int rob(int[] nums) {
       int len = nums.length, result = 0, max = 0;
       int[] dp = new int[len];

       for (int i = len - 1; i >= 0; i--){
           dp[i] = max + nums[i];
           if (i + 1 < len) {
               max = Math.max(dp[i + 1], max);
           }
           result = Math.max(dp[i], result);
       }
       return result;
    }

    public static void main(String[] args) {
        num198 a = new num198();
        int[] nums = {1, 2, 3, 1};
        System.out.print(a.rob(nums));
    }
}
