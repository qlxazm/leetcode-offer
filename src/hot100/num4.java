package hot100;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class num4 {

    /*private double num = 0;
    private double count = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, i = 0, j = 0, k = 0;
        double last = 0;
        int middleInex = (len1 + len2) / 2;

        // 一些特殊情况
        if (len1 == 0 && len2 == 0) {return 0;}

        while (k < middleInex && i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                last = nums1[i];
                i++;
            }else {
                last = nums2[j];
                j++;
            }
            k++;
        }


        if (i == len1) {
            while (k < middleInex) {
                last = nums2[j++];
                k++;
            }
            middleInex = nums2[j];
        } else if (j == len2) {
            while (k < middleInex) {
                last = nums1[i++];
                k++;
            }
            middleInex = nums1[i];
        } else {
            middleInex = Math.min(nums1[i], nums2[j]);
        }


        return ((len1 + len2) & 1) == 1 ? middleInex : ((double) middleInex + last) / 2;
    }*/

    /*private void set(int[] nums) {
        int len = nums.length;
        if ((len & 1) == 1){
            num += 1;
            count += nums[len / 2];
        }else {
            num += 2;
            count += nums[len / 2] + nums[len / 2 - 1];
        }
    }*/

    /*
    *   双指针法
    * */
    /*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int aIndex = 0, bIndex = 0;
        int pre = -1, curr = -1;

        for (int i = 0; i < len / 2 + 1; i++) {
            pre = curr;
            if (aIndex < m && (bIndex >= n || nums1[aIndex] < nums2[bIndex])) {
                curr = nums1[aIndex++];
            } else {
                curr = nums2[bIndex++];
            }
        }
        return (len & 1) == 0 ? (pre + curr) / 2.0 : curr;
    }*/

    /*
    * 方法2
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;

        if ((len & 1) == 1) {
            return getKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2 + 1);
        } else {
            return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2 + 1)) / 2.0;
        }
    }

    public int getKth(final int[] A, int aStart, int aEnd, final int[] B, int bStart, int bEnd, final int K) {

        if (aStart > aEnd) {return B[bStart + K - 1];}
        if (bStart > bEnd) {return A[aStart + K - 1];}
        if (K == 1) {return Math.min(A[aStart], B[bStart]);}


        int aIndex = Math.min(aStart + K / 2 - 1, aEnd);
        int bIndex = Math.min(bStart + K / 2 - 1, bEnd);

        if (A[aIndex] > B[bIndex]) {
            // 抛弃B中的[bStart, bIndex]范围内的数据
            return getKth(A, aStart, aEnd, B, bIndex + 1, bEnd, K - (bIndex - bStart + 1));
        }else {
            return getKth(A, aIndex + 1, aEnd, B, bStart, bEnd, K - (aIndex - aStart + 1));
        }
    }

    public static void main(String[] args) {
       /* int[] num1 = {1, 3};
        int[] num2 = {2};*/
       /* int[] num1 = {1, 2};
        int[] num2 = {3, 4};*/
   /*     int[] num1 = {};
        int[] num2 = {1};*/
       /* int[] num1 = {3};
        int[] num2 = {-2, -1};*/
        int[] num1 = {1, 1, 3, 3};
        int[] num2 = {1, 1, 3, 3};
        num4 a = new num4();
        System.out.println(a.findMedianSortedArrays(num1, num2));
    }
}
