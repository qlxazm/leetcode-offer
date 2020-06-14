package hot100;

import java.util.Arrays;

/**
 * 看成0-1背包问题，数组的值表示物品重量，物品价值为1
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class num416 {

    public boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;
        for (int num : nums) { sum += num;}

        // 如果和是奇数直接返回
        if ((sum & 1) == 1){return false;}

        int capacity = sum / 2;
        // dp的第一维代表取nums数组0~i之间的数，第二维代表希望的和
        boolean[] dp = new boolean[capacity + 1];

        for (int i = 0; i < len; i++) {
            for (int j = capacity; j >=0; j--) {
                dp[j] = dp[j] || j == nums[i - 1] || (j > nums[i] && dp[j - nums[i]]);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        num416 a = new num416();
        int[] nums = {1, 2, 3, 5};
//        int[] nums = {23,13,11,7,6,5,5};
//        int[] nums = {1,2,5};
        System.out.print(a.canPartition(nums));
    }
}
