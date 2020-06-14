package hot100;

/**
 * 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class num1143 {

    /**
     * 带有备忘录的回溯算法
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        Integer[][] dp = new Integer[m][n];
        return longestCommonSubsequence(text1, m - 1, text2, n - 1, dp);
    }
    public int longestCommonSubsequence(String text1, int i, String text2, int j, final Integer[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int ans = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = longestCommonSubsequence(text1, i - 1, text2, j - 1, dp) + 1;
        } else {
            ans = Math.max(longestCommonSubsequence(text1, i - 1, text2, j, dp),
                    longestCommonSubsequence(text1, i, text2, j - 1, dp));
        }
        dp[i][j] = ans;
        return ans;
    }

    /**
     * dp解法
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 用于自底向上构建最长子串
        int[][] b = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    // 从对角线来的
                    b[i][j] = 2;
                }else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        // 从上一行来的
                        b[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i][j - 1];
                        // 从右侧来的
                        b[i][j] = 3;
                    }
                }
            }
        }

        // 构建解
        int i = m, j = n;
        StringBuilder builder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                builder.append(text1.charAt(i - 1));
            }
            if (b[i][j] == 1) {
                i -= 1;
            }else if (b[i][j] == 2) {
                i -= 1;
                j -= 1;
            }else {
                j -= 1;
            }
        }

        System.out.println("最长公共子序列是" + builder.reverse().toString());

        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        num1143 a = new num1143();
        a.longestCommonSubsequence1(text1, text2);
    }
}
