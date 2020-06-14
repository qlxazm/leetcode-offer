package algorithm;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 */
public class MyQueue {

    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> worker = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        migrate();
        int ans = worker.pop();
        rebuild();
        return ans;
    }

    private void migrate() {
        while (!stack.isEmpty()) {
            worker.push(stack.pop());
        }
    }

    private void rebuild() {
        while (!worker.isEmpty()) {
            stack.push(worker.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        migrate();
        int ans = worker.peek() == null ? -1 : worker.peek();
        rebuild();
        return ans;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
