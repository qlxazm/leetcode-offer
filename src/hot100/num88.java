package hot100;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author qian
 * @date 2020/1/19 20:24
 */
public class num88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*int[] buffer = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        for (; i < m; i++) {buffer[i] = nums1[i];}

        i = j = 0;
        while (k < (m + n) && i < m && j < n) {
            nums1[k++] = buffer[i] < nums2[j] ? buffer[i++] : nums2[j++];
        }

        while (i < m) { nums1[k++] = buffer[i++]; }
        while (j < n) { nums1[k++] = nums2[j++]; }*/

        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (k >= 0 && j >= 0 && i >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (j >= 0) {nums1[k--] = nums2[j--];}
    }

    public static void main(String[] args) {
        num88 a = new num88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        a.merge(nums1, 3, nums2, 3);
    }
}
