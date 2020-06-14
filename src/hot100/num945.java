package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */
public class num945 {

    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0, len = A.length; i < len; i++) {
            set.add(A[i]);
        }

        int lastNum = -1, lastIndex = 0, ans = 0;
        for (int i = 0, len = A.length; i < len; i++) {
            if (A[i] == lastNum) {
                // 需要进行去重
                lastIndex = Math.max(lastIndex, A[i]) + 1;
                while (set.contains(lastIndex)) {
                    lastIndex++;
                }
                ans += lastIndex - A[i];
                set.add(lastIndex);
            }else {
                lastNum = A[i];
            }
        }
        return ans;
    }

    public int minIncrementForUnique(int[] A) {
        final int NUM_MAX_VALUE = 40000;
        int[] buffer = new int[NUM_MAX_VALUE];
        HashSet<Integer> set = new HashSet<>();
        int max = -1, ans = 0;

        for (int i = 0, len = A.length; i < len; i++) {
            max= Math.max(max, A[i]);
            buffer[A[i]]++;
            set.add(A[i]);
        }

        int last = 0;
        for (int i = 0; i <= max; i++) {
            if (buffer[i] > 1) {
                last = Math.max(last, i);
                while (buffer[i] > 1) {
                    last++;
                    while (set.contains(last)) {
                        last++;
                    }
                    ans += last - i;
                    set.add(last);
                    buffer[i]--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 2, 1, 7};
        num945 a = new num945();
        System.out.println(a.minIncrementForUnique(A));
    }

}
