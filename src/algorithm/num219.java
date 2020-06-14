package algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class num219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int num = 0;
        Integer lastIndex = 0;
        for(int i = 0, len = nums.length; i < len; i++) {
            num = nums[i];
            if((lastIndex = map.get(num)) != null && Math.abs(lastIndex - i) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
