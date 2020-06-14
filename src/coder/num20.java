package coder;

import java.util.Set;
import java.util.Stack;

public class num20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}
