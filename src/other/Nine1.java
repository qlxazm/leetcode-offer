package other;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/4/11 19:56
 */
public class Nine1 {

    public String add (String num1, String num2) {
        int i1 = num1.indexOf(".");
        int i2 = num2.indexOf(".");
        int len1 = num1.length();
        int len2 = num2.length();

        // 对齐小数部分
        String s1 = i1 == -1 ? "" : num1.substring(i1 + 1);
        String s2 = i2 == -1 ? "" : num2.substring(i2 + 1);
        int k = Math.max(s1.length(), s2.length()), j;

        j = s1.length();
        while (j < k) {
            s1 += "0";
            j++;
        }

        j = s2.length();
        while (j < k) {
            s2 += "0";
            j++;
        }
        // 小数部分相加
        String ans1 = add(s1, s2, 0);

        // 对齐整数部分
        s1 = num1.substring(0, i1);
        s2 = num2.substring(0, i2);
        while (i1 < i2) {
            s1 = "0" + s1;
            i1++;
        }

        while (i2 < i1) {
            s2 = "0" + s2;
            i2++;
        }

        if (ans1.length() > k) {
            String ans2 = add(s1, s2, ans1.charAt(0) - '0');
            if (k > 0) {
                return ans2 + "." + ans1.substring(1);
            }
            return ans2;
        } else {
            String ans2 = add(s1, s2, 0);
            if (k > 0) {
                return ans2 + "." + ans1;
            }
            return ans2;
        }
    }

    public String add (String num1, String num2, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = num1.length() - 1; i >= 0; i--) {
            int k = (num1.charAt(i) - '0') + (num2.charAt(i) - '0') + n;
            builder.append(k % 9);
            n = k / 9;
        }
        if (n > 0) { builder.append(n); }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.nextLine().split(",");
        Nine1 nine = new Nine1();
        System.out.println(nine.add(num[0], num[1]));
    }
}
