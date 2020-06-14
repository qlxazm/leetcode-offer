package algorithm;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/4/26 20:46
 */
public class Ancestor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            while (q > 0) {
                long x = scanner.nextLong();
                int k = scanner.nextInt();
                int level = 1;
                long levenMax = 2;
                while (x >= levenMax) {
                    level++;
                    levenMax *= 2;
                }
                if (k >= level) {
                    System.out.println(-1);
                } else {
                    for (int i = 0; i < level; i++) {
                        x /= 2;
                    }
                    System.out.println(x);
                }

                q--;
            }
        }
    }
}
