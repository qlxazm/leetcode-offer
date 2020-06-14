package algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 */
public class num217 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
