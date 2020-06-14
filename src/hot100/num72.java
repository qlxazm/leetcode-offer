package hot100;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class num72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length(), i, j;
        if (len2 == 0) {return len1;}
        if (len1 == 0) {return len2;}
        if (word1.equals(word2)){return 0;}


        int[][] dp = new int[len1][len2];

        //初始化
        dp[len1 - 1][len2 - 1] = word1.charAt(len1 - 1) == word2.charAt(len2 - 1) ? 0 : 1;
        for (i = len1 - 2; i >= 0; i--){
            dp[i][len2 - 1] = word1.charAt(i) == word2.charAt(len2 - 1) ? (len1 - i - 1) : dp[i + 1][len2 - 1] + 1;
        }
        for (i = len2 - 2; i >= 0; i--){
            dp[len1 - 1][i] = word2.charAt(i) == word1.charAt(len1 - 1) ? (len2 - i - 1) : dp[len1 - 1][i + 1] + 1;
        }

        for (i = len1 - 2; i >= 0; i--){
            for (j = len2 - 2; j >= 0; j--){
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }else {
                    int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    min = Math.min(min, dp[i + 1][j + 1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        num72 a = new num72();
        String word1 = "horse";
        String word2 = "ros";
       /* String word1 = "intention";
        String word2 = "execution";*/
       /* String word1 = "sea";
        String word2 = "eat";*/
        System.out.println(a.minDistance(word1, word2));
    }
}
