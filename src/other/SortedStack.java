package other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sort-of-stacks-lcci/
 */
public class SortedStack {
    private Queue<Integer> stack;
    public SortedStack() {
        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        stack = new PriorityQueue<Integer>(cmp);
    }

    public void push(int val) {
        stack.add(val);
    }

    public void pop() {
        stack.poll();
    }

    public int peek() {
        return stack.peek() == null ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
