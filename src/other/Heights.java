package other;

/**
 * 快手笔试题
 */
public class Heights {
    public int[] heights(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                ans[i] = 1;
            } else {
                int j = i - 1;
                while (ans[j] > 0 && nums[i] >= nums[j - ans[j]]) {
                    j -= ans[j];
                }
                if (ans[j] == 0) {
                    ans[i] = 0;
                }else {
                    ans[i] = i - (j - ans[j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {175, 173, 174, 163, 182, 177};
        Heights a = new Heights();
        nums = a.heights(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
