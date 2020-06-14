package other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 快速排序
 */
public class FastSort {

    public List<Integer> sortArray(int[] nums) {
        fastSort(nums, 0, nums.length - 1);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private void fastSort(int[] nums, final int start, final int end) {
        // 轴
        int i = start, j = end;
        int axis = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= axis) { j--; }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && nums[i] < axis) { i++; }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = axis;
        if (start < i) { fastSort(nums, start, i - 1); }
        if (i < end) { fastSort(nums, i + 1, end); }
    }

}
