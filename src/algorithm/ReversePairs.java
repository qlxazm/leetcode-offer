package algorithm;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePairs {

    private int[] buffer;

    private int ans = 0;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        buffer = new int[len];
        partition(nums, 0, len - 1);
        return 0;
    }

    public void partition(int[] nums, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            partition(nums, i, mid);
            partition(nums, mid + 1, j);
            merge(nums, i, mid, j);
        }
    }

    public void merge(int[] nums, int lower, int mid, int hight) {
        for (int i = lower; i <= hight; i++) {
            buffer[i] = nums[i];
        }

        int i = lower, j = mid + 1, k = lower;
        while (i <= mid && j <= hight) {
            if (buffer[i] <= buffer[j]) {
                nums[k] = buffer[i];
                i++;
                ans += j - (mid + 1);
            } else {
                nums[k] = buffer[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            nums[k++] = buffer[i++];
            ans += hight - mid;
        }

        while (j <= hight) {
            nums[k++] = buffer[j++];
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs.reversePairs(nums));
    }

}
