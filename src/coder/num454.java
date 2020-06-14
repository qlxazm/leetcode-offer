package coder;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class num454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i, j, k, result, N = A.length;
        int[] matrix = new int[N * N];
        k = 0;
        Integer temp = null;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                matrix[k++] = A[i] + B[j];
                temp = C[i] + D[j];
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                }else {
                    map.put(temp, 1);
                }
            }
        }

        result = 0;
        for (i = 0; i < N * N; i++) {
            temp = matrix[i];
            temp = map.get((~temp) + 1);
            if (temp != null) {
                result += temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        num454 a = new num454();

        System.out.println(a.fourSumCount(A, B, C, D));

    }
}
