package algorithm;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class num43 {

    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int i = len1 - 1, j = len2 - 1, f = 0;
        char[] ans = new char[len1 + len2];

        for (; j >= 0; j--) {
            for (i = len1 - 1; i >= 0; i--) {
                f = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 关键点是计算合适的位置
                int index = i + j + 1;
                do {
                    f += ans[index] == 0 ? 0 : (ans[index] - '0');
                    ans[index] = (char)(f % 10 + '0');
                    f /= 10;
                    index--;
                }while (f != 0);
            }
        }



        i = 0;
        while (i < (len1 + len2) && ans[i] <= '0') {
            i++;
        }

        return i == (len1 + len2) ? "" : new String(ans, i, len1 + len2 - i);
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

       /* String num1 = "9";
        String num2 = "9";*/

        num43 num43 = new num43();
        System.out.println(num43.multiply(num1, num2));
    }
}
