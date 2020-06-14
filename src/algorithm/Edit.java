package algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 */
public class Edit {

    private String content = "";

    private LinkedList<String> lastLine = new LinkedList<>();

    public void add(String s, boolean isRollback) {
        if (!isRollback) {
            lastLine.offer("1 " + s);
        }
        content += s;
    }

    public void delete(int k, boolean isRollback) {
        int len = content.length();
        if (k <= len) {
            if (!isRollback) {
                // 删除的时候记录下删除了谁
                lastLine.offer("2 " + content.substring(len - k, len));
            }
            content = content.substring(0, len - k);
        }
    }

    public void print(int k) {
        System.out.println(content.charAt(k - 1));
    }

    public void rollback() {
        if (lastLine.size() == 0) {
            return ;
        }

        String[] command = lastLine.pollLast().split(" ");

        int op = Integer.valueOf(command[0]);

        switch (op) {
            case 1:
                delete(command[1].length(), true);
                break;
            case 2:
                add(command[1], true);
                break;
        }
    }

    public void setLastLine(String lastLine) {
        this.lastLine.offer(lastLine);
    }

    public static void main(String[] args) {

        Edit edit = new Edit();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        while (N > 0) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");

            int op = Integer.valueOf(command[0]);

            switch (op) {
                case 1:
                    edit.add(command[1], false);
                    break;
                case 2:
                    edit.delete(Integer.valueOf(command[1]), false);
                    break;
                case 3:
                    edit.print(Integer.valueOf(command[1]));
                    break;
                case 4:
                    edit.rollback();
                    break;
            }
            N--;
        }
    }
}
