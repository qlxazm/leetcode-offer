package hot100;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * @author qian
 * @date 2020/2/4 22:07
 */
public class num162 {

    public int findPeakElement(int[] nums) {

        int lower = 0, higher = nums.length - 1;
        while (lower < higher) {
            int middle = (lower + higher) / 2;
            if (nums[middle] < nums[middle + 1]) {
                lower = middle + 1;
            } else {
                higher = middle;
            }
        }
        return lower;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        num162 a = new num162();
        System.out.println(a.findPeakElement(nums));
    }
}
