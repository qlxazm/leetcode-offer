package hot100;

/**
 * @author qian
 * @date 2020/1/11 21:48
 */
public class num581 {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length, i, first = -1, last = -1;

        int max = Integer.MIN_VALUE;
        for (i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            if (max != nums[i]) {
                first = i;
            }
        }

        int min = Integer.MAX_VALUE;
        for (i = len - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (min != nums[i]) {
                last = i;
            }
        }

        return first == - 1 ? 0 : first - last + 1;
    }

    public static void main(String[] args) {
        num581 a = new num581();
//        int[] nums = {2,6,4,8,10,9,15};
//        int[] nums = {2, 1};
//        int[] nums = {1, 3, 2, 2, 2};
        int[] nums = {2, 3, 3, 2, 4};
        System.out.print(a.findUnsortedSubarray(nums));
    }
}
