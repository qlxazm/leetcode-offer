package algorithm;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/calculator-lcci/
 */
public class num26 {

    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        char sign = '+', c = 0;
        int num = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            c = s.charAt(i);
            if (isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOperator(c) || i == (len - 1)) {
                int k = 0;
                switch (sign){
                    case '+':
                        stack.offer(num);
                        break;
                    case '-':
                        stack.offer(-num);
                        break;
                    case '*':
                        k = stack.pollLast() * num;
                        stack.offer(k);
                        break;
                    case '/':
                        k = stack.pollLast() / num;
                        stack.offer(k);
                        break;
                }
                sign = c;
                num = 0;
            }
        }

        int ans = 0;
        for (Integer i : stack) {
            ans += i;
        }
        return ans;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        num26 num26 = new num26();
        System.out.println(num26.calculate(s));
    }

}
