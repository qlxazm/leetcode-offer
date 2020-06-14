package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class num969 {

    public List<Integer> pancakeSort(int[] A) {
        ArrayList<Integer> ans = new ArrayList<>();
        pancakeSort(A, A.length - 1, ans);
        return ans;
    }

    private void pancakeSort(int[] A, int n, ArrayList<Integer> ans) {
        if (n > 0) {
            // 寻找最大值
            int i = 1, maxIndex = 0;
            while (i <= n) {
                if (A[i] > A[maxIndex]) {maxIndex = i;}
                i++;
            }
            reversal(A, 0, maxIndex);
            if (maxIndex > 0) {
                ans.add(maxIndex + 1);
            }
            reversal(A, 0, n);
            ans.add(n + 1);
            // 递归调用
            pancakeSort(A, n - 1, ans);
        }
    }

    private void reversal(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[end];
            A[end] = A[start];
            A[start] = temp;
            start++;
            end--;
        }
    }

}
