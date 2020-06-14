package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 */
public class num169 {
    public int majorityElement(int[] nums) {
        /*
        方法1：哈希表法
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, len = nums.length;
        for (; i < len; i++) { map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1); }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len / 2) {return entry.getKey();}
        }
        return 0;*/

        int len = nums.length, i = 1, last = nums[0], count = 1;
        while (i < len) {
            count = nums[i] == last ? count + 1 : count - 1;
            if (count == 0) {
                last = nums[i];
                count = 1;
            }
            i++;
        }
        return last;
    }

    public static void main(String[] args) {
        num169 a = new num169();
        int[] nums = {3, 2, 3};
        System.out.print(a.majorityElement(nums));
    }
}
