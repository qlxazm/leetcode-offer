package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 利用num31中下一个排列的思想
 */
public class num46 {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean flag = true;
        int i = 0, j, len = nums.length;
        while (flag) {
            flag = false;
            result.add(copyArrayToList(nums));

            for (i = len - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    flag = true;
                    break;
                }
            }


            if (i == -1) {
                break;
            }

            for (j = len - 1; j > i; j--) {
                if (nums[j] > nums[i]) {break;}
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            revese(nums, i + 1, len - 1);
        }
        return result;
    }

    public List<Integer> copyArrayToList(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++){
            result.add(nums[i]);
        }
        return result;
    }

    public void revese(int[] nums, int begin, int end) {
        while (begin <= end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        num46 a = new num46();
        int[] nums = {1,2,3};
        List<List<Integer>> result = a.permute(nums);
        for (int i = 0, len = result.size(); i < len; i++) {
            List<Integer> list = result.get(i);
            for (int j = 0, len1 = list.size(); j < len1; j++) {
                System.out.print(list.get(j) + ",");
            }
            System.out.println("");

        }
    }
}
