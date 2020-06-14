package algorithm;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class num224 {

    public int calculate(String s) {
        int[] ans = calculate(s, 0);
        return ans[1];
    }

    public int[] calculate(String s, int i) {
        int len = s.length();
        int[] ans = {0,0};
        char sign = '+', c = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int num = 0;
        for (; i < len; i++) {
            c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                // 开启递归
                int[] temp = calculate(s, i + 1);
                num = temp[1];
                i = temp[0];
            }


            if (isOperator(c) || i == (len - 1) || c == ')') {
                switch(sign) {
                    case '+':
                        stack.offer(num);
                        break;
                    case '-':
                        stack.offer(-num);
                        break;
                }
                if (c == ')') {
                    ans[0] = i;
                    break;
                }
                sign = c;
                num = 0;
            }
        }

        for (Integer n : stack) {
            ans[1] += n;
        }
        return ans;
    }

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        num224 num224 = new num224();
        System.out.println(num224.calculate(s));
    }
}
