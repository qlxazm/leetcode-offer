package other;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/4/11 19:08
 */
public class Nine {

    /**
     * 接收两个表示9进制数的字符串，返回表示它们相加后的9进制数的字符串
     * @param num1 string字符串 第一个加数
     * @param num2 string字符串 第二个加数
     * @return string字符串
     */
    public String add (String num1, String num2) {
        int i1 = num1.indexOf(".");
        int i2 = num2.indexOf(".");
        int len1 = num1.length();
        int len2 = num2.length();

        // 没有小数部分
        if (i1 == -1 && i2 == -1) {
            int a = Integer.parseInt(num1, 9);
            int b = Integer.parseInt(num2, 9);
            return Integer.toString(a + b, 9);
        } else if (i1 == -1) {
            int a = Integer.parseInt(num1, 9);
            int b = Integer.parseInt(num2.substring(0, i2), 9);
            return Integer.toString(a + b, 9) + "." + num2.substring(i2 + 1);
        } else if (i2 == -1) {
            int a = Integer.parseInt(num1.substring(0, i1), 9);
            int b = Integer.parseInt(num2, 9);
            return Integer.toString(a + b, 9) + "." + num1.substring(i1 + 1);
        } else {
            // 小数点的长度
            int size = Math.max(len1 - i1, len2 - i2) - 1;
            int k = len1 - i1 - 1;
            while (k < size) {
                num1 += "0";
                k++;
            }

            k = len2 - i2 - 1;
            while (k < size) {
                num2 += "0";
            }

            num1 = num1.replace(".", "");
            num2 = num2.replace(".", "");
            int a = Integer.parseInt(num1, 9);
            int b = Integer.parseInt(num2, 9);
            String ans = Integer.toString(a + b, 9);
            return ans.substring(0, ans.length() - size) + "." + ans.substring(ans.length() - size);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] num = scanner.nextLine().split(",");
        Nine nine = new Nine();
        System.out.println(nine.add(num[0], num[1]));
    }
}
