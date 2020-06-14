package recruite;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/3/29 19:41
 */
public class MinK {

    public void minK() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        int i = 0;
        while (i < n) {
            a[i++] = scanner.nextLong();
        }

        long k = 0;
        int maxIndex = getMaxIndex(a, -1, 0, n);
        while (a[maxIndex] >= n) {
            long diff = a[maxIndex] / n;
            a[maxIndex] %= n;
            maxIndex = getMaxIndex(a, maxIndex, diff, n);
            k += diff;
        }
        System.out.println(k);
    }

    private int getMaxIndex(long[] nums, int tempMaxIndex, long diff, final int N) {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (i != tempMaxIndex) {
                nums[i] += diff;
            }
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MinK a = new MinK();
        a.minK();
    }
}
