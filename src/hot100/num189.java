package hot100;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * @author qian
 * @date 2020/2/5 19:31
 */
public class num189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length, temp;
        if ((k = k % n) == 0) { return; }

        revert(nums, 0, n - 1);
        revert(nums, 0, k - 1);
        revert(nums, k, n - 1);
    }

    private void revert(int[] nums, int lower, int higher) {
        int temp;
        while (lower < higher) {
            temp = nums[lower];
            nums[lower++] = nums[higher];
            nums[higher--] = temp;
        }
    }

    public static void main(String[] args) {
       /* int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;*/

       /* int[] nums = {-1};
        int k = 2;*/

        int[] nums = {1, 2, 3};
        int k = 2;

        num189 a = new num189();
        a.rotate(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
