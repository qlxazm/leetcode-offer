package algorithm;

/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class NumOfSubArray {

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        // 计算每个奇数右边偶数的个数
        int count = 0, index = -1, len = nums.length;
        int[] after = new int[len];
        int[] before = new int[len];
        for (int i = 0; i < len; i++) {
            if ((nums[i] & 1) == 1) {
                if (index > -1) {after[index] = count;}
                before[i] = count;
                index = i;
                count = 0;
            } else {
                count++;
            }
        }
        if (index > -1) {
            after[index] = count;
        }

        int left = 0, right = 0, matches = 0, ans = 0;
        while (right < len) {
            if ((nums[right] & 1) == 1) {
                matches++;
            }
            right++;

            if (matches == k) {
                while (matches == k) {
                    if ((nums[left] & 1) == 1) {matches--;}
                    left++;
                }
                ans += (before[left - 1] + 1) * (after[right - 1] + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        NumOfSubArray numOfSubArray = new NumOfSubArray();
        System.out.println(numOfSubArray.numberOfSubarrays(nums, 2));
        System.out.println(-5 / 2);
    }
}
