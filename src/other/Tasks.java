package other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yd
 * @date 2020/4/11 21:04
 */
public class Tasks {

    public void tasks() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] W = new int[N];
        int[] T = new int[N];
        int i = 0;
        while (i < N) {W[i++] = scanner.nextInt();}
        i = 0;
        while (i < N) {T[i++] = scanner.nextInt();}
        Arrays.sort(W);
        Arrays.sort(T);
        long ans = tasks(W, 0, N - 1, T);
        int M = scanner.nextInt();
        System.out.println(ans % M);
    }

    public long tasks(int[] W, int i, int j, int[] T) {
        if (i == j) {return 1;}
        long ans = 1;
        if (W[i] >= T[j]) {
            long k = j - i + 1;
            while (k > 0) {
                ans *= k;
                k--;
            }
            return ans;
        }

        int mid = (i + j) / 2;
        ans = tasks(W, i, mid, T) * tasks(W, mid + 1, j, T);
        return ans;
    }

    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        tasks.tasks();
    }

}
