package algorithm;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class num33 {

    public int search(int[] nums, int target) {

        int len = nums.length, lower = 0, hight = len - 1;
        while (lower <= hight) {
            int mid = lower + (hight - lower) / 2;
            if (target == nums[mid]) {
                return mid;
            } else {
                // 如果目标值在左半边
                if (target > nums[len - 1]) {
                    // 现在lower和hight已经在左边啦
                    if (nums[mid] > target) {
                        hight = mid - 1;
                    } else {
                        if (nums[mid] > nums[len - 1]) {
                            lower = mid + 1;
                        } else {
                            hight = mid - 1;
                        }
                    }
                } else {
                    // 目标值在右半边
                    if (nums[mid] < target) {
                        lower = mid + 1;
                    } else {
                        if (nums[mid] > nums[len - 1]) {
                            lower = mid + 1;
                        } else {
                            hight = mid - 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        num33 num33 = new num33();
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(num33.search(nums, 0));
    }
}
