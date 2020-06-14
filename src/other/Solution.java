package other;

/**
 * @author yd
 * @date 2020/4/14 22:51
 */
public class Solution {
    public int strToInt(String str) {
        char[] charArray = str.trim().toCharArray();
        if (charArray.length == 0) {return 0;}
        int i = 0, sign = 0;
        if (charArray[0] == '+') {
            i = 1;
            sign = 1;
        } else if (charArray[0] == '-') {
            i = 1;
            sign = -1;
        } else {
            i = 0;
            sign = 1;
        }
        long ans = 0;
        for (int j = i, len = charArray.length; j < len; j++) {
            if (charArray[j] < '0' || charArray[j] > '9') {break;}
            ans = ans * 10 + (charArray[j] - '0');
            if (ans > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return (int)(sign * ans);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "42";
        System.out.println(solution.strToInt(str));
    }
}
