package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class num152 {


   /* public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, len = nums.length;
        int[] dp = new int[len];
        boolean[] isSelf = new boolean[len];

        dp[len - 2] = nums[len - 1] * nums[len - 2];
        isSelf[len - 2] = true;
        for (int i = len - 3; i >= 0; i--){
            if (isSelf[i + 1]) {
                dp[i] = (isSelf[i] = dp[i + 1] * nums[i] >= dp[i + 1]) ? dp[i + 1] * nums[i] : dp[i + 1];
            }else {
                int tempIndex = i + 1, temp, product = nums[i] * nums[i + 1], j = i + 2;
                temp = product;
                // 从 i 到第一个isSelf[]为true位置之内范围的最大值
               *//* for (; j < len && !isSelf[j]; j++) {
                    temp *= nums[j];
                    if (temp >= product) {
                        product = temp;
                        tempIndex = j;
                    }
                }
                if (isSelf[i] = product >= dp[j]) {
                    dp[i] = product;
                }else {
                    dp[i] = dp[j];
                }*//*

            }
        }
    }*/

    public int maxProduct(int[] nums) {
        /*
        方法1：动态规划法
        int len = nums.length, max = Integer.MIN_VALUE, i, j, k;
        int[] dp = new int[len];

        for (i = 0; i < len; i++) {
            dp[i] = nums[i];
            max = Math.max(max, dp[i]);
            for (j = i + 1; j < len; j++) {
                dp[j] = dp[j - 1] * nums[j];
                max = Math.max(dp[j], max);
            }
        }
        return max;*/

        /**
         * 1、根据0的位置，将问题切分成不包含0的子问题
         * 2、如果子问题中负数的个数是偶数个，直接返回结果，否则，还需要进一步计算
         */
        int len = nums.length;
        if (len == 1) {return nums[0];}
        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        /**
         * 记录各个子问题中负数的个数。如果负数的个数是偶数，那么最大子序列将是整个数组
         * 如果负数的个数是奇数，那么最大子序列将是个子数组
         */
        List<Integer> negativeNum = new ArrayList<>();

        // 跳过开头的0
        int i, j, k, max = Integer.MIN_VALUE;
        i = k = 0;
        while (k < len && nums[k] == 0) {i++; k++;}

        for (j = 0; k < len; k++){
            if (nums[k] == 0) {
                lower.add(i);
                higher.add(k - 1);
                negativeNum.add(j);
                i = k + 1;
                j = 0;
            }else if (nums[k] < 0) {
                j++;
            }
        }

        if (nums[k - 1] != 0) {
            lower.add(i);
            higher.add(k - 1);
            negativeNum.add(j);
        }

        for (i = 0, len = negativeNum.size(); i < len; i++) {
            max = Math.max(max, maxProduct(nums, lower.get(i), higher.get(i), negativeNum.get(i) % 2 == 0));
        }

        return Math.max(max, 0);
    }

    private int maxProduct(int[] nums, int start, int end, boolean negativeCountIsOdd) {
        int product = 1, i;
        for (i = start; i <= end; i++) {
            product *= nums[i];
        }
        if (negativeCountIsOdd || start == end) {return product;}

        int max = Integer.MIN_VALUE, temp = 1;
        for (i =  start; i <= end; i++) {
            temp *= nums[i];
            if (nums[i] < 0) {
                max = i == start ? Math.max(max, product / temp) : Math.max(max, Math.max(temp / nums[i], product / temp));
            }
        }
        return max;
    }

    public int maxProduct1(int[] nums) {
        int ans = Integer.MIN_VALUE, len = nums.length;
        for (int i = 0; i < len; i++){
            int temp = 1;
            for (int j = i; j < len; j++) {
                temp *= nums[j];
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        num152 a = new num152();
        int[] nums = {2, -5, -2, -4, 3};
        System.out.println(a.maxProduct1(nums));

        Lock lock = new ReentrantLock();
        lock.newCondition();
    }
}
