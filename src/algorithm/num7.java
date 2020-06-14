package algorithm;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class num7 {

    public int reverse(int x) {
        char[] charArray = Integer.toString(x).toCharArray();
        // 是否是负数
        boolean isNagetive = charArray[0] == '-';
        long ans = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                ans = ans * 10 + (c - '0');
                if (!isValid(ans, isNagetive)) {return 0;}
            }
        }

        return isNagetive ? (int)-ans : (int)ans;
    }

    private boolean isValid(long num, boolean isNagetive) {
        return (isNagetive && -num >= Integer.MIN_VALUE) || (!isNagetive && num <= Integer.MAX_VALUE);
    }
}
