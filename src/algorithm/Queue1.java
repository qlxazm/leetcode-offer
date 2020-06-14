package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 */
public class Queue1 {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> work = new LinkedList<>();

    public void add(int val) {
        while (!stack.isEmpty()) {
            work.push(stack.pop());
        }
        stack.push(val);
        while (!work.isEmpty()) {
            stack.push(work.pop());
        }
    }

    public void poll() {
        stack.poll();
    }

    public int peek() {
        return stack.peek();
    }

    public static void main(String[] args) {
        Queue1 queue = new Queue1();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        while (N > 0) {
            String[] line = scanner.nextLine().split(" ");
            int num = 0;
            String op = line[0];
            if (line.length > 1) {
                num = Integer.valueOf(line[1]);
            }

            switch (op) {
                case "add":
                    queue.add(num);
                    break;
                case "peek":
                    System.out.println(queue.peek());
                    break;
                case "poll":
                    queue.poll();
                    break;
            }

            N--;
        }
    }
}
