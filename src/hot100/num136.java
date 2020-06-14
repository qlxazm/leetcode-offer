package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用异或运算
 * https://leetcode-cn.com/problems/single-number/
 */
public class num136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) { result ^= num; }
        return result;
    }

    public static void main(String[] args) {
        num136 a = new num136();
        int[] nums = {1,2,2,1,4};
        System.out.println(a.singleNumber(nums));
    }
}
