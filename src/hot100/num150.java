package hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 后缀式
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author qian
 * @date 2020/2/4 21:37
 */
public class num150 {

    public int evalRPN(String[] tokens) {
        LinkedList<String> queue = new LinkedList<>();

        for(String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                String op2 = queue.pollFirst();
                String op1 = queue.pollFirst();
                token = compute(token, op1, op2);
            }
            queue.offerFirst(token);
        }

        return Integer.valueOf(queue.pollFirst());
    }

    private String compute(String token, String op1, String op2) {
        int a = Integer.valueOf(op1), b = Integer.valueOf(op2), ans = 0;
        if (token.equals("+")) {
            ans = a + b;
        } else if (token.equals("-")) {
            ans = a - b;
        } else if (token.equals("*")) {
            ans = a * b;
        } else if (token.equals("/")) {
            ans = a / b;
        }
        return String.valueOf(ans);
    }



    public static void main(String[] args) {
    }
}
