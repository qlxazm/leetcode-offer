package algorithm;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author yd
 * @date 2020/5/11 10:38
 */
public class Translate {

    public static void main(String[] args) {
        int a = 835672545;
        Scanner scanner = new Scanner(System.in);
        String article = scanner.nextLine();
        int n = Integer.valueOf(scanner.nextLine());
        HashSet<String> dict = new HashSet<>();

        // 读取字典
        while (n > 0) {
            dict.add(scanner.nextLine().trim());
            n--;
        }

        int articleLen = article.length();
        int[] dp = new int[articleLen + 1];
        dp[0] = 1;

        for (int i = 1; i <= articleLen; i++) {
            for (int j = 0; j < i; j++) {
                String word = article.substring(j, i);
                if (dict.contains(word)) {
                    dp[i] += dp[j];
                }
            }
        }

        /*for (int i = articleLen - 1; i >= 0; i--) {
            for (int j = i; j < articleLen; j++) {
                String word = article.substring(i, j + 1);
                if (dict.contains(word)) {
                    dp[i] = i == j ? 1 : dp[i] + dp[j + 1];
                    if (dp[i] >= a) {
                        dp[i] %= a;
                    }
                }
            }
        }*/

        System.out.println(dp[articleLen]);
    }
}
