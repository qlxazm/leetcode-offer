package algorithm;

import java.util.HashMap;
import java.util.HashSet;

/**
 *  https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class num1248 {

    /**
     * 前缀和方法
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0, count = 0;

        for (int i = 0, len = nums.length; i < len; i++) {
            count += nums[i] & 1;
            map.put(count, map.getOrDefault(count, 0) + 1);
            if (map.containsKey(count - k)) {
                ans += map.get(count - k);
            }
        }

        return ans;
    }

    /**
     * 滑动窗口，left right两个指针，先让right一直走，直到[left, right]之间有k个奇数。
     * 计算第一个奇数之前的偶数的个数为sum1，再计算最后一个奇数之后的偶数的个数为sum2。
     * 统计(sum1 + 1) * (sum2 + 1)到ans，
     * 让left执行第一个奇数之后，right执行了最后一个奇数之后的下一个奇数
     *
     * 这个方法比较快
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays1(int[] nums, int k) {
        int ans = 0, len = nums.length;
        int left = 0, right = 0, oddNum = 0;

        while (right < len) {
            oddNum += nums[right++] & 1;
            // 开始统计
            if (oddNum == k) {
                // 左边偶数的个数
                int sum1 = 0;
                while ((nums[left] & 1) == 0) {
                    sum1++;
                    left++;
                }
                // left指向第一个奇数之后
                left++;
                // 奇数个数减1
                oddNum--;

                // 右边偶数的个数
                // right执行最后一个奇数之后的第一个奇数
                int sum2 = 0;
                while (right < len && (nums[right] & 1) == 0) {
                    sum2++;
                    right++;
                }

                ans += (sum1 + 1) * (sum2 + 2);
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        num1248 num1248 = new num1248();
        System.out.println(num1248.numberOfSubarrays(nums, 2));
    }
}
