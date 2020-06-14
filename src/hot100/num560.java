package hot100;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @author qian
 * @date 2020/1/7 10:18
 */
public class num560 {

    public int subarraySum(int[] nums, int k) {

        /*
        * 方法1：暴力解决
        * 这种方法是O(m³)的时间复杂度，会超时
        * */
       /* int len = nums.length, result = 0;
        for (int i = 1; i <= len; i++) {
            // 子数组的长度从1到len
            for (int j = 0; j <= len - i; j++) {
                int tempSum = 0;
                for (int m = j; m <= j + i - 1; m++) {
                    tempSum += nums[m];
                }
                if (tempSum == k) {result++;}
            }
        }

        return result;*/

       /*
       * 方法2：保存中间结果
       * 虽然通过了，但是效率也不是很高
       * */
       int len = nums.length, result = 0;
       int[] dp = new int[len];

       for (int i = 1; i <= len; i++) {
           int[] next = new int[len];
           for (int j = 0; j <= len - i; j++) {
               if ((next[j] = dp[j] + nums[j + i - 1]) == k) {result++;}
           }
           dp = next;
       }
       return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        num560 a = new num560();

        System.out.print(a.subarraySum(nums, k));
    }
}
