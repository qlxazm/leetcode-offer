package algorithm;

import java.util.Scanner;

/**
 */
public class Card {

    private int ans = Integer.MAX_VALUE;

    public int minTimes(int[] a, int[] b, int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = a[i];
        }

        for (int i = 0; i < n - 1; i++) {
            dfs(num, i, n);
        }
        return ans;
    }

    public void dfs(int[] num, int i, int n) {
        if (isSorted(num)) {
            ans = Math.min(ans, n);
            return;
        }


        for (int j = 0; j < n; j++) {
            if (j == i) {continue;}
            dfs(num, j, n);
        }

    }

    private boolean isSorted(int[] num) {
        for (int i = 0, len = num.length - 1; i < len; i++) {
            if (num[i + 1] < num[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Card card = new Card();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(card.minTimes(a, b, n));
    }
}
