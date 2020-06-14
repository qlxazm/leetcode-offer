package hot100;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * 单纯的采用递归的话，会超时，因为相同的子问题计算了多次，
 *  动态规划
 */
public class num679 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = i;
            for (int j = (int)Math.sqrt(i); j >= 1; j--) {
                if ((dp[i] = Math.min(dp[i], 1 + dp[i - j * j])) == 1) {
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        num679 a = new num679();
        System.out.print(a.numSquares(10000));
    }
}
