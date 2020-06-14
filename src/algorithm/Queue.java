package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 */
public class Queue {

    public static void main(String[] args) {
        LinkedList<Integer> queue = null;
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            queue = new LinkedList<>();
            int Q = scanner.nextInt();
            scanner.nextLine();
            while (Q > 0) {
                String[] line = scanner.nextLine().split(" ");
                String op = line[0];
                int num = 0;
                if (line.length > 1) {
                    num = Integer.valueOf(line[1]);
                }
                switch (op) {
                    case "PUSH":
                        queue.addLast(num);
                        break;
                    case "TOP":
                        System.out.println(queue.isEmpty() ? -1 : queue.peek());
                        break;
                    case "POP":
                        if (queue.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            queue.pop();
                        }
                        break;
                    case "SIZE":
                        System.out.println(queue.size());
                        break;
                    case "CLEAR":
                        queue.clear();
                        break;
                }
                Q--;
            }

            T--;
        }
    }
}
