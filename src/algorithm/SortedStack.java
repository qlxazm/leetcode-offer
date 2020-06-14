package algorithm;

import java.util.LinkedList;

/**
 */
public class SortedStack {

    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> worker = new LinkedList<>();

    public SortedStack() {

    }

    public void push(int val) {
        while(!isEmpty() && stack.peek() < val) {
            worker.push(stack.pop());
        }
        stack.push(val);
        while(!worker.isEmpty()) {
            stack.push(worker.pop());
        }
    }

    public void pop() {
        stack.pollFirst();
    }

    public int peek() {
        return isEmpty() ? -1 : stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
