package algorithm;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 */
public class num220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if (len < 2) {return false;}
        // TreeSet是一个平衡二叉树
        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        for (int i = 1; i < len; i++) {
            // 大于等于nums[i]的最小数
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= t + nums[i]) {return true;}

            // 小于等于nums[i]的最大数
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= t + g) {return true;}

            if (i >= k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {

        int len = nums.length;
        if (len < 2 || k == 0) {return false;}

        HashMap<Long, Long> map = new HashMap<>();
        long tl = (long)t;

        for (int i = 0; i < len; i++) {
            // 计算桶编号
            long id = (long)nums[i] / (2 * tl + 1);
            if (map.containsKey(id) && isValid(map.get(id), nums[i], tl)) {return true;}
            if (map.containsKey(id - 1) && isValid(map.get(id - 1), nums[i], tl)) {return true;}
            if (map.containsKey(id + 1) && isValid(map.get(id + 1), nums[i], tl)) {return true;}
            if (i >= k) {
                long id1 = (long)nums[i - k] / (2 * tl + 1);
                map.remove(id1);
            }
            map.put(id, (long)nums[i]);
        }

        return false;
    }

    private boolean isValid(long a, int b, long t) {
        long bl = (long) b;

        return a > bl ? a - bl <= t : bl - a <= t;
    }

    private long abs(int a, int b) {
        long al = (long) a;
        long bl = (long) b;
        return al - bl < 0 ? bl - al : al - bl;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2147483647, 2147483647};
//        int[] nums = {1, 5, 9, 1, 5, 9};
//        int[] nums = {7,2,8};
        num220 num220 = new num220();
//        System.out.println(num220.containsNearbyAlmostDuplicate(nums, 1, 1));
//        System.out.println(num220.containsNearbyAlmostDuplicate(nums, 2, 3));
//        System.out.println(num220.containsNearbyAlmostDuplicate(nums, 2, 1));
//        int[] nums = {3, 6, 0, 4};
        int[] nums = {0, 2147483647};
//        System.out.println(num220.containsNearbyAlmostDuplicate1(nums, 2, 2));
        System.out.println(num220.containsNearbyAlmostDuplicate1(nums, 1, 2147483647));
    }
}
