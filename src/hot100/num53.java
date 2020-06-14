package hot100;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class num53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {return 0;}
        int sum = nums[0], max = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            // 更换子数组
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        num53 a = new num53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(a.maxSubArray(nums));
    }
}
