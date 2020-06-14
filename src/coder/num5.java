package coder;

import java.util.ArrayList;
import java.util.List;

public class num5 {
    /**
     * 最长公共子串（连续）
     * @param a
     */
    /*public String lcs (String a) {
        String b = reverse(a);

        int length = a.length();
        int[][] table = new int[length + 1][length + 1];

        //计算公共子串的长度
        int maxLength = Integer.MIN_VALUE;
        String longestResult = "";
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                    String longestSubstr = a.substring(i - table[i][j], i);
                    String reversedLongestSubstr = reverse(longestSubstr);
                    if ((i - table[i][j]) == a.indexOf(reversedLongestSubstr)) {
                        if (table[i][j] > maxLength) {
                            maxLength = table[i][j];
                            longestResult = longestSubstr;
                        }
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return longestResult;
    }

    private String reverse(String a) {
        return new StringBuilder(a).reverse().toString();
    }*/

    public String dp(String a) {

        int length = a.length();
        if (length == 0) {
            return "";
        }

        boolean[][] table = new boolean[length][length];

        int maxLength = 1;
        int startIndex = -1;
        for (int i = 0; i < length - 1; i++) {
            table[i][i] = true;
            table[i][i + 1] = a.charAt(i) == a.charAt(i + 1);
            if (table[i][i + 1]){
                maxLength = 2;
                startIndex = i;
            }
        }
        table[length - 1][length - 1] = true;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = (i + 2); j < length; j++) {
                table[i][j] = table[i + 1][j - 1] && a.charAt(i) == a.charAt(j);
                if (table[i][j] && (j - i + 1) > maxLength) {
                    maxLength = (j - i + 1);
                    startIndex = i;
                }
            }
        }

        return maxLength == 1 ? String.valueOf(a.charAt(0)) : a.substring(startIndex, startIndex + maxLength);
    }

    /**
     * 这是进一步减少内存消耗的版本
     * @param a
     * @return
     */
    public String dp1(String a) {

        int length = a.length();
        if (length == 0 || length == 1) {
            return a;
        }

        boolean[] table1 = new boolean[length];
        int maxLength = Integer.MIN_VALUE;
        int startIndex = -1;
        for (int i = length - 1; i >= 0; i--){
            for (int j = (i + 2); j < length; j++){
                table1[j] = table1[j - 1] && a.charAt(i) == a.charAt(j);
                if (table1[j] && (j - i + 1) > maxLength) {
                    maxLength = (j - i + 1);
                    startIndex = i;
                }
            }
            table1[i] = true;
            if ((i + 1) < length) {
                table1[i + 1] = a.charAt(i) == a.charAt(i + 1);
                if (table1[i + 1] && maxLength < 2) {
                    maxLength = 2;
                    startIndex = i;
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ? String.valueOf(a.charAt(0)) : a.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(new num5().dp1("abcba"));
    }
}