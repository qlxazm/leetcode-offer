package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qian
 * @date 2020/1/6 10:35
 */
public class num448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        /*
        * 这是官方题解
        * */
        int nextIndex = 0;
        for (int i = 0, len = nums.length; i < len; i++){
            nextIndex = Math.abs(nums[i]) - 1;
            if (nums[nextIndex] > 0) { nums[nextIndex] *= -1;}
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] > 0) {results.add(i + 1);}
        }

        return results;

        /*for (int i = 0, len = nums.length; i < len; i++){
           if (nums[i] == 0) {continue;}
           int nextIndex = nums[i] - 1, temp;
           while (nextIndex >= 0 && nums[nextIndex] != 0) {
                temp = nums[nextIndex];
                nums[nextIndex] = 0;
                nextIndex = temp - 1;
           }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] != 0) {results.add(i + 1);}
        }

        return results;*/
    }

    public static void main(String[] args) {
        num448 a = new num448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        for (int num : a.findDisappearedNumbers(nums)) {
            System.out.print(num + ", ");
        }
    }
}
