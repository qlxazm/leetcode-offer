package algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class num523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) { return false;}

        HashSet<Integer> set = new HashSet<>();
        int i = 0, sum = 0;
        set.add(sum);
        for (; i < len; i++) {
            sum += nums[i];
            set.add(sum);

            int n = sum % k;
            if (n < 0) {
                while (n * k > nums[i]) {
                    if (set.contains(sum -  n * k)) {
                        return true;
                    }
                    n++;
                }
            } else if (n > 0){
                while (n * k > nums[i]) {
                    if (set.contains(sum -  n * k)) {
                        return true;
                    }
                    n--;
                }
            }

        }


        return false;
    }

    public static void main(String[] args) {
        num523 num523 = new num523();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(num523.checkSubarraySum(nums, -6));
    }

}
