package algorithm;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) {return len;}

        int i = 0, j = 1;
        while (j < len) {
            if (nums[j] != nums[i]) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            j++;
        }
        return i + 1;
    }

}
