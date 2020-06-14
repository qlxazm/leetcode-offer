package recruite;

import java.util.Scanner;

/**
 */
public class Main {

    public void change() {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        String[] map = scanner.nextLine().trim().split(" ");

        int i = 0, len = s.length();
        StringBuilder builder = new StringBuilder();
        if (s.charAt(0) == '-') {
            builder.append('-');
            i++;
        }

        while (i < len) {
            builder.append(map[s.charAt(i) - '1']);
            i++;
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.change();
    }
}
