package algorithm;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class num8 {

    public int myAtoi(String str) {
        char[] charArray = str.trim().toCharArray();
        int i = 0, flag = 1;
        int len = charArray.length;
        if (len == 0) {return 0;}
        if (charArray[0] == '-') {
            i = 1;
            flag = -1;
        } else if (charArray[0] == '+') {
            i = 1;
        }

        long ans = 0;
        for (; i < len; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {break;}
            ans = ans * 10 + (charArray[i] - '0');
            if (ans > Integer.MAX_VALUE) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return (int)(ans * flag);
    }
}
