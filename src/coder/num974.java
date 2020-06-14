package coder;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class num974 {
    public int subarraysDivByK(int[] A, int K) {
        int i, len = A.length, count = 0;
        for (i = 0; i < len; i++) { A[i] %= K; }
        // 前缀和数组
        int[] sums = new int[len + 1];
        int[] tempCount = new int[K + 1];
        tempCount[0] = 1;
        for (i = 0; i < len; i++) {
            sums[i + 1] = sums[i] + A[i];
            int key = sums[i + 1] % K;
            if (key < 0) { key += K; }
            count += tempCount[key];
            tempCount[key] += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        num974 a = new num974();
        //-3,5,7,9,-7,4,10,-9,4,7
        //4,5,0,-2,-3,1
        int[] data = {4,5,0,-2,-3,1};
        System.out.println(a.subarraysDivByK(data, 5));
    }
}
