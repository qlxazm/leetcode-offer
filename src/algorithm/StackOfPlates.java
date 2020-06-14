package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/stack-of-plates-lcci/
 */
public class StackOfPlates {

    LinkedList<LinkedList<Integer>> table = new LinkedList<>();
    /**
     * 栈的容量
     */
    int capacity = 0;

    public StackOfPlates(int cap) {
        capacity = cap;
    }

    public void push(int val) {
        if (capacity <= 0) {
            return;
        }
        int size = table.size();
        LinkedList<Integer> stack = null;
        if (size == 0 || (table.get(size - 1)).size() == capacity) {
            table.add(new LinkedList<>());
            size++;
        }
        stack = table.get(size - 1);
        stack.offerFirst(val);
    }

    public int pop() {
        return popAt(table.size() - 1);
    }

    public int popAt(int index) {
        if (index >= table.size() || capacity <= 0) {
            return -1;
        }

        LinkedList<Integer> stack = table.get(index);
        int ans = stack.pollFirst();
        if (stack.isEmpty()) {
            table.remove(index);
        }
        return ans;
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(2);
        stackOfPlates.push(1);
        stackOfPlates.push(2);
        stackOfPlates.push(3);

        stackOfPlates.popAt(0);
        stackOfPlates.popAt(0);
        stackOfPlates.popAt(0);
    }
}
