package hot100;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * @author qian
 * @date 2020/1/13 16:47
 */
public class num647 {

    /**
     * 动态规划方法
     * @param s
     * @return
     */
    /*public int countSubstrings(String s) {
        int len = s.length(), result = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 1; i <= len; i++) {
            for (int j = 0, k = j + i - 1; j < len && k < len; j++, k = j + i - 1) {
                dp[j][k] = s.charAt(j) == s.charAt(k) && (k - 1 < j + 1 || dp[j + 1][k - 1]);
                if (dp[j][k]){result++;}
            }
        }
        return result;
    }*/

    /**
     * 中心扩展法
     * @param s
     * @return
     */
    /*public int countSubstrings(String s) {
        int len = s.length(), ans = 0, left, right;
        // 有2 * len - 1个可能的回文中心
        for (int i = 1; i <= 2 * len - 1; i++) {
            left = right = i / 2;
            if (i % 2 == 0) { left--; }
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }*/

    /**
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        return 0;
    }

    public static void main(String[] args) {
//        String s = "abc";

        String s = "aaaaa";

        num647 a = new num647();

        System.out.print(a.countSubstrings(s));
    }
}
