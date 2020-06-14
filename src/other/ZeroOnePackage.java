package other;

/**
 * 0-1背包问题
 * 问题描述
 * 现给定n种物品以及一容量为c的背包，物品具有质量和价值两个属性，物品i的质量为wi，价值为vi。问如何选择装入背包的物品，才能使得背包中物品的总价值最大？
 * 给定数据为背包容量c = 10, 物品种类n = 5, 物品质量w[n] = {2, 2, 6, 5, 4}, 物品价值v[n] = {6, 3, 5, 4, 6}。
 * @author qian
 * @date 2020/1/5 17:22
 */
public class ZeroOnePackage {

    public int solution(int[] goodsWeight, int [] goodsValue, int packageCapacity) {
        int n = goodsWeight.length;
        // dp数组 第一维代表当前使用的物品数目，假设是2，就代表0、1、2号物品加入了问题
        // 第二维代表当前使用的背包的重量
        int[][] dp = new int[n + 1][packageCapacity + 1];

        // 初始化，加入0号物品
       /* for (int i = 0; i <= packageCapacity; i++) {
           dp[0][i] = goodsWeight[0] > i ? 0 : goodsValue[0];
        }*/

        for (int i = 1; i <= n; i++) {
            int weight = goodsWeight[i - 1], value = goodsValue[i - 1];
            for (int j = 0; j <= packageCapacity; j++) {
                // 物品的重量大于背包的容量，当前物品(i)肯定不可以放入背包
                if (weight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 否则分为两种情况，i物品放入背包和不放入背包
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        return dp[n][packageCapacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 2, 6, 5, 4};
        int[] values = {6, 3, 5, 4, 6};
        ZeroOnePackage a = new ZeroOnePackage();
        System.out.println(a.solution(weights, values, 10));
    }
}
