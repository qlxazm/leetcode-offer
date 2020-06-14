package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class num78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subSetsRecursive(result, nums, 0);
        result.add(new ArrayList<>());
        return result;
    }

    public void subSetsRecursive(List<List<Integer>> list, int[] nums, int begin) {
        if (begin == nums.length) {return;}
        List<Integer> newList = null;
        subSetsRecursive(list, nums, begin + 1);
        for (int i = 0, len = list.size(); i <= len; i++){
            newList = i < len ? new ArrayList<>(list.get(i)) : new ArrayList<>();
            newList.add(nums[begin]);
            list.add(newList);
        }
    }

    public static void main(String[] args) {
        num78 a = new num78();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = a.subsets(nums);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
