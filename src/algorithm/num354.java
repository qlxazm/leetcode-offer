package algorithm;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 */
public class num354 {

    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length, ans = 1;
        if (len == 0) {return 0;}
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        Arrays.sort(envelopes, ((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        }));

        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
