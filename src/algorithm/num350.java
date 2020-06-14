package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class num350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Integer last = null;
        for (int num : nums2) {
            if ((last = map.get(num)) != null && last > 0) {
                ans.add(num);
                map.put(num, last - 1);
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;
        for (Integer num : ans) {
            result[i++] = num;
        }

       return result;
    }
}
