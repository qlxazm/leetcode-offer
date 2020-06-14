package algorithm;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/interval-list-intersections/
 */
public class num986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<Integer[]> buffer = new ArrayList<>();

        int aLen = A.length, bLen = B.length;
        int i = 0, j = 0;
        while (i < aLen && j < bLen) {
            // 没有交集
            if (A[i][0] > B[j][1] || A[i][1] < B[j][0]) {
                i++;
                j++;
                continue;
            }
            buffer.add(new Integer[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
            if (A[i][1] > B[j][1]) {
                j++;
            } else {
                i++;
            }
        }

        int size = buffer.size();
        int[][] res = new int[size][2];
        i = 0;
        for (Integer[] pair : buffer) {
            res[i] = new int[]{pair[0], pair[1]};
            i++;
        }

        return res;
    }
}
