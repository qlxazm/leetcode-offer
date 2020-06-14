package algorithm;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Atoi {

    public int myAtoi(String str) {
        char[] charArray = str.trim().toCharArray();
        int len = charArray.length;
        if (len == 0) {return 0;}

        long ans = 0;
        boolean isNagetive = charArray[0] == '-';
        int i = charArray[0] == '-' || charArray[0] == '+' ? 1 : 0;
        while (i < len && isNumber(charArray[i])) {
            ans = ans * 10 + (charArray[i] - '0');
            if (ans > Integer.MAX_VALUE) {
                return isNagetive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }
        return isNagetive ? (int)-ans : (int)ans;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
