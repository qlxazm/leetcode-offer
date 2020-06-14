package algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/new-21-game/
 */
public class num837 {

    private double probability = 0;
    private HashMap<Integer, Double> buffer = new HashMap<>();

    /**
     * 自顶向下，带备忘录的解法，超时
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        probability = 1 / (double) W;
        return f(K, W, N, K);
    }
    public double f(int i, final int W, final int N, final int K) {
        // 备忘录中有
        if (buffer.containsKey(i)) {
            return buffer.get(i);
        }

        if (i <= 0) {
            return K - i <= N ? 1 : 0;
        }
        double ans = 0;
        for (int j = 1; j <= W; j++) {
            ans += probability * f(i - j, W, N, K);
        }
        buffer.put(i, ans);
        return ans;
    }

    /**
     * 牛逼题解  https://leetcode-cn.com/problems/new-21-game/solution/huan-you-bi-zhe-geng-jian-dan-de-ti-jie-ma-tian-ge/
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game1(int N, int K, int W) {
        // dp[x]表示在已有分数x的情况下，获胜的概率
        double[] dp = new double[K + W];
        //在[K, K + W - 1]之间的满足 i <= N的肯定获胜的概率是1
        for (int i = K; i <= N && i < K + W ; i++) {
            dp[i] = 1;
        }

        // 第一次计算前缀和
        double tmp = 0;
        if (K > 0) {
            for (int i = K; i < K + W; i++) {
                tmp += dp[i];
            }
            dp[K - 1] = tmp / W;
        }

        for (int i = K - 2; i >= 0; i--) {
            tmp += dp[i + 1] - dp[i + W + 1];
            dp[i] = tmp / W;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        num837 num837 = new num837();
        System.out.println(num837.new21Game1(21, 17, 10));
    }
}
