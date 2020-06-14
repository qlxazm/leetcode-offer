package hot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/
 * @author qian
 * @date 2020/2/5 10:50
 */
public class num166 {

    public String fractionToDecimal(int numerator, int denominator) {
        // 是否异号
        boolean isDiff = (numerator < 0 && denominator > 0 ) || (numerator > 0 && denominator < 0);

        long temp = numerator / denominator;
        String quotient = String.valueOf(temp >= 0 ? temp : -temp);
        StringBuilder builder = new StringBuilder();
        HashMap<Long, Integer> buffer = new HashMap<>();
        int i = quotient.length(), j = -1;
        long num = numerator;
        do {
            temp = num / denominator;
            builder.append(String.valueOf(temp >= 0 ? temp : -temp));
            num %= denominator;
            if (buffer.containsKey(num)) {
                j = buffer.get(num);
                break;
            }
            buffer.put(num, i++);
            num *= 10;
        }while (num != 0);

        // 如果是无限循环小数
        String ans = builder.toString();
        if (j != -1) {
            ans = ans.substring(0, j) + "(" + ans.substring(j) + ")";
        }
        // 计算小数点的位置
        if (quotient.length() < ans.length()) {
            ans = ans.substring(0, quotient.length()) + "." + ans.substring(quotient.length());
        }

        return isDiff ? "-" + ans : ans;
    }

    public static void main(String[] args) {
        num166 a = new num166();
//        System.out.println(a.fractionToDecimal(-1, -2147483648));
        System.out.println(a.fractionToDecimal(-2147483648, 1));
//        System.out.println(a.fractionToDecimal(2, 3));
//        System.out.println(a.fractionToDecimal(-50, 8));
    }
}
