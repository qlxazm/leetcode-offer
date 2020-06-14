package algorithm;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/5/11 11:36
 */
public class Answer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n > 0) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");
            int op = Integer.valueOf(command[0]);

            if (op == 2) {
                int i = Integer.valueOf(command[1]) - 1, j = Integer.valueOf(command[2]) - 1;
                boolean[] buffer = new boolean[26];
                while (i <= j) {
                    buffer[(str.charAt(i) - 'a')] = true;
                    i++;
                }
                i = 0;
                j = 0;
                while (i < 26) {
                    if (buffer[i]) {j++;}
                    i++;
                }
                System.out.println(j);
            } else if (op == 1) {
                int i = Integer.valueOf(command[1]);
                str = str.substring(0, i - 1) + command[2] + str.substring(i);
            }

            n--;
        }
    }
}
