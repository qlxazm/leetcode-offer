package coder;

import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/smallest-range-ii/
 *
 * 答案都看不懂
 */
public class num910 {

        public int smallestRangeII(int[] A, int K) {
            int N = A.length;
            Arrays.sort(A);
            int ans = A[N-1] - A[0];

            for (int i = 0; i < A.length - 1; ++i) {
                int a = A[i], b = A[i+1];
                int high = Math.max(A[N-1] - K, a + K);
                int low = Math.min(A[0] + K, b - K);
                ans = Math.min(ans, high - low);
            }
            return ans;
        }


    public static void main(String[] args) {
        int[] array = {1,3, 6};
        num910 a = new num910();

        System.out.println(a.smallestRangeII(array, 3));
    }
}
