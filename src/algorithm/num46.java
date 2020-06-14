package algorithm;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class num46 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        Set<Integer> options = new HashSet<>(len);
        for (int num : nums) {options.add(num);}
        List<List<Integer>> ans = new LinkedList<>();
        permute(nums, new LinkedList<>(), ans, len);
        return ans;
    }

    public void permute(int[] nums, LinkedList<Integer> path, List<List<Integer>> ans, int len) {
        if (path.size() == len) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (path.contains(nums[i])) {continue;}
            path.add(nums[i]);
            permute(nums, path, ans, len);
            path.removeLast();
        }

    }

    public static void main(String[] args) {

    }
}
