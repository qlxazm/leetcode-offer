package hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/
 * @author qian
 * @date 2020/1/18 17:31
 */
public class num44 {

    public boolean isMatch(String s, String p) {

        int pLen = p.length(), sLen = s.length();

        if (sLen == 0) {return p.equals("*") || p.equals("");}
        if (pLen == 0) {return false;}

        boolean[][] dp = new boolean[pLen + 1][sLen + 1];

        // 初始化
        dp[pLen][sLen] = true;

        for (int i = pLen - 1; i >= 0; i--) {
            for (int j = sLen; j >= 0; j--) {
                if (p.charAt(i) == '*') {
                    if (j == sLen) {
                        dp[i][j] = dp[i + 1][j];
                    }else {
                        dp[i][j] = dp[i + 1][j + 1] || dp[i][j + 1] || dp[i + 1][j];
                    }
                } else {
                    dp[i][j] = j < sLen && dp[i + 1][j + 1] && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j));
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        /*String s = "aa";
        String p = "a";*/

       /* String s = "aa";
        String p = "*";*/

      /*  String s = "cb";
        String p = "?a";*/

        String s = "adceb";
        String p = "*a*b";

      /*  String s = "acdcb";
        String p = "a*c?b";*/

       /* String s = "a";
        String p = "a**";*/

        num44 a = new num44();
        System.out.println(a.isMatch(s, p));

    }
}
