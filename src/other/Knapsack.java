package other;

/**
 * 完全背包问题，完全背包问题与0-1背包的区别在于完全背包中的物品的数量是无限多个的
 * https://www.imooc.com/article/286140
 * https://blog.csdn.net/weixin_41162823/article/details/87878853
 * @author qian
 * @date 2020/1/15 14:07
 */
public class Knapsack {

    /**
     * 物品的价值(第一个位置不用)
     */
    private static int[] P = {0, 5, 8};

    private static int[] PRICE = {5, 8};

    /**
     * 物品的重量(第一个位置不用)
     */
    private static int[] V = {0, 5, 7};

    private static int[] VOLUMN = {5, 7};

    /**
     * 背包容量
     */
    private static int T = 10;

    private Integer[][] buffer = new Integer[P.length + 1][T + 1];

    private int[][] dp = new int[P.length + 1][T + 1];

    /**
     * 递归方法(至上而下)
     * @param i
     * @param T
     * @return
     */
    public int ks(int i, int T) {
        int ans = 0;
        if (i != 0 && T != 0) {
            for (int k = 0; k * V[i] <= T; k++) {
                ans = Math.max(ks(i - 1, T - k * V[i]) + k * P[i], ans);
            }
        }
        return ans;
    }

    /**
     * 自上而下的记忆法
     * @param i
     * @param T
     * @return
     */
    public int ks2(int i, int T) {
        // 查找缓存
        if (buffer[i][T] != null) {
            return buffer[i][T];
        }
        int ans = 0;
        if (i != 0 && T != 0) {
            for (int k = 0; k * V[i] <= T; k++) {
                ans = Math.max(ks(i - 1, T - k * V[i]) + k * P[i], ans);
            }
            buffer[i][T] = ans;
        }
        return ans;
    }

    /**
     * 自下而上的dp
     * @return
     */
    public int ks3() {
        for (int i = 1; i <= PRICE.length; i++) {
            for (int j = 0; j <= T; j++) {
                for (int k = 0; k * VOLUMN[i - 1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j - k * VOLUMN[i - 1]] + PRICE[i - 1] * k, dp[i][j]);
                }
            }
        }
        return dp[PRICE.length][T];
    }

    /**
     * 优化版的dp
     * @return
     */
    public int ks4() {
        for (int i = 1; i <= PRICE.length; i++) {
            for (int j = VOLUMN[i]; j <= T; j++) {
                dp[i][j] = Math.max(dp[i][j - VOLUMN[i - 1]] + PRICE[i - 1], dp[i - 1][j]);
            }
        }
        return dp[PRICE.length][T];
    }

    public static void main(String[] args) {
        Knapsack a = new Knapsack();

        // 方法1：
//        System.out.println(a.ks(P.length - 1, 9));
        // 方法2：
//        System.out.println(a.ks2(P.length - 1, T));

        // 方法3：
        System.out.println(a.ks2(P.length - 1, T));
    }
}
