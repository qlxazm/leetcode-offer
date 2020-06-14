package hot100;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class num238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefixProduct = new int[len  + 1], suffixProduct = new int[len + 1];
        prefixProduct[0] = suffixProduct[len - 1] = 1;

        for (int i = 1; i <= len; i++){prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];}
        for (int i = len - 2; i >= 0; i--){suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];}
        for (int i = 0; i < len; i++) {nums[i] = prefixProduct[i] * suffixProduct[i];}
        return nums;
    }

    public static void main(String[] args) {

    }
}
