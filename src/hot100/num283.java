package hot100;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class num283 {
    public void moveZeroes(int[] nums) {
        int zeroNum = 0, len = nums.length, slow = 0, fast = 0;
        while (fast < len) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }else {
                zeroNum++;
            }
            fast++;
        }
        for (int i = len - 1, n = len - zeroNum; i >= n; i--){nums[i] = 0;}
    }

    public static void main(String[] args) {

    }
}
