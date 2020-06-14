package recruite;

import java.util.Scanner;

/**
 */
public class Repeat {

    public void repeat() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int k = scanner.nextInt();
        double mod = 1e9+7;
        double[] nums = new double[N + 1];
        int i = 1;
        for (; i <= N; i++) {
            nums[i] = scanner.nextInt() % mod;
        }

        i = 1;
        while (i <= k) {
            double[] buffer = new double[N + 1];
            buffer[1] = nums[1] % mod;
            for (int j = 2; j <= N; j++) {
                buffer[j] = buffer[j - 1] + nums[j] % mod;
            }
            nums = buffer;
            // 进入下一轮
            i++;
        }
        nums[N] = nums[N] % mod;
        System.out.println((long) nums[N]);
    }

    public static void main(String[] args) {
        Repeat a = new Repeat();
        a.repeat();
//        double mod = 1e9+7;
//        System.out.println(Integer.MAX_VALUE - mod);
    }
}
