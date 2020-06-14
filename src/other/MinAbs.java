package other;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/3/25 16:31
 */
public class MinAbs {

    public void minAbs() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[3][n + 1];
        int i = 0;
        while (i < 3) {
            int j = 1;
            while (j <= n) {
                nums[i][j++] = scanner.nextInt();
            }
            i++;
        }

        long[][] dp = new long[3][n + 1];
        for (i = 2; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + Math.abs(nums[0][i] - nums[0][i - 1]);
            dp[0][i] = Math.min(dp[0][i], dp[1][i - 1] + Math.abs(nums[0][i] - nums[1][i - 1]));
            dp[0][i] = Math.min(dp[0][i], dp[2][i - 1] + Math.abs(nums[0][i] - nums[2][i - 1]));

            dp[1][i] = dp[0][i - 1] + Math.abs(nums[1][i] - nums[0][i - 1]);
            dp[1][i] = Math.min(dp[1][i], dp[1][i - 1] + Math.abs(nums[1][i] - nums[1][i - 1]));
            dp[1][i] = Math.min(dp[1][i], dp[2][i - 1] + Math.abs(nums[1][i] - nums[2][i - 1]));

            dp[2][i] = dp[0][i - 1] + Math.abs(nums[2][i] - nums[0][i - 1]);
            dp[2][i] = Math.min(dp[2][i], dp[1][i - 1] + Math.abs(nums[2][i] - nums[1][i - 1]));
            dp[2][i] = Math.min(dp[2][i], dp[2][i - 1] + Math.abs(nums[2][i] - nums[2][i - 1]));

        }

        long ans = Math.min(dp[0][n], dp[1][n]);
        System.out.println(Math.min(ans, dp[2][n]));
    }

    public static void main(String[] args) {
//        other.MinAbs a = new other.MinAbs();
//        a.minAbs();
    }
}
