package hot100;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class num75 {
    public void sortColors(int[] nums) {
        int redCount, whiteCount, blueCount, i, n, len;
        redCount = whiteCount = blueCount = 0;
        for (i = 0, len = nums.length; i < len; i++){
            if (nums[i] == 0) {
                redCount++;
            }else if (nums[i] == 1) {
                whiteCount++;
            }else {
                blueCount++;
            }
        }

        for (i = 0, n = redCount; i < n; i++) {
            nums[i] = 0;
        }
        for (n = i + whiteCount; i < n; i++) {
            nums[i] = 1;
        }
        for (n = i + blueCount; i < n; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        num75 a = new num75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        a.sortColors(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + ",");
        }
    }
}
