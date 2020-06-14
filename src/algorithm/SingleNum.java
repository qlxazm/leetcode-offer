package algorithm;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class SingleNum {
    public int[] singleNumbers(int[] nums) {
        int[] ans = {0, 0};
        int temp = 0, len = nums.length, i = 0;
        while (i < len) {
            temp ^= nums[i];
            i++;
        }

        // 找到第一个1的位置
        int first = 1;
        while ((temp & 1) != 1) {
            temp = temp >>> 1;
            first *= 2;
        }

        i = 0;
        while (i < len) {
            if ((nums[i] & first) == first) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        SingleNum singleNum = new SingleNum();
        int[] nums = {1, 2, 5, 2};
        nums = singleNum.singleNumbers(nums);
        System.out.println(nums[0]);
        System.out.println(nums[1]);
    }
}
