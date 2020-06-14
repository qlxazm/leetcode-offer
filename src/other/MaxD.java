package other;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/4/7 19:29
 */
public class MaxD {

    public void maxD() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int i = 0;
        while (i < n) {
            a[i] = scanner.nextInt();
            if (i > 0) {
                a[i - 1] = a[i] - a[i - 1];
            }
            i++;
        }
        int k = n - 1, j = 0;
        while (k != 1) {
            i = 0;
            j = 0;
            while (i + 1 < k) {
                a[j] = gcd(a[i], a[i + 1]);
                j++;
                i += 2;
            }
            if (i < k) {
                a[j] = a[i];
                j++;
            }
            k = j;
        }
        System.out.println(a[0]);
    }

    public int gcd(int a, int b) {
        int ans = b == 0 ? a : gcd(b, a % b);
        return ans;
    }

    public static void main(String[] args) {
        MaxD a = new MaxD();
        a.maxD();
    }
}
