package other;

/**
 *https://leetcode-cn.com/problems/sorted-merge-lcci/
 */
public class MergeArray {

    public void merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (A[m] >= B[n]) {
                A[k--] = A[m--];
            } else {
                A[k--] = A[n--];
            }
        }
        while (n >= 0) {
            A[k--] = B[n--];
        }
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 0, 0, 0};
        int[] B = {1, 2, 3};

        MergeArray a = new MergeArray();
        a.merge(A, 3, B, 3);

        for (int num : A) {
            System.out.print(num + ",");
        }
    }
}
