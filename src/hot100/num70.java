package hot100;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class num70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 <= n) {dp[i] += dp[i + 1];}
            if (i + 2 <= n) {dp[i] += dp[i + 2];}
        }
        return dp[0];
    }

    public static void main(String[] args) {
        num70 a = new num70();
        System.out.println(a.climbStairs(3));
    }
}
