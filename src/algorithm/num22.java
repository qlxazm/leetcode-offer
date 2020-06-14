package algorithm;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class num22 {

    /**
     * 深度优先搜索
     * 需要观察到，当左括号的数量大于右括号的数量时肯定剪枝
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] chars = new char[2 * n];
        generate(ans, chars, 0, n, n);
        return ans;
    }
    public void generate(List<String> ans, char[] chars, int position, int left, int right) {
        // 当左括号的数量小于右括号的数量时剪枝
        if (left <= right) {
            if (left == right && left == 0) {
                ans.add(new String(chars));
            } else {
                if (left > 0) {
                    chars[position] = '(';
                    generate(ans, chars, position + 1, left - 1, right);
                }
                if (right > 0) {
                    chars[position] = ')';
                    generate(ans, chars, position + 1, left, right - 1);
                }
            }
        }
    }


    class Node {
        private String str;
        private int left;
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
    /**
     * 广度优先搜索
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        List<String> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node p = queue.poll();

            if (p.left == 0 && p.right == 0) {
                ans.add(p.str);
                continue;
            }
            if (p.left > 0) {
                queue.offer(new Node(p.str + "(", p.left - 1, p.right));
            }
            if (p.right > 0 && p.left < p.right) {
                queue.offer(new Node(p.str + ")", p.left, p.right - 1));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        num22 num22 = new num22();
        for (String s : num22.generateParenthesis1(3)) {
            System.out.println(s);
        }
    }
}
