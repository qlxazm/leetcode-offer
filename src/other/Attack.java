package other;

import java.util.Scanner;

/**
 */
public class Attack {

    public void attack() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n, m, a, b;
        while (T > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(maxMum(n, m, a, b));
            T--;
        }


    }

    public int maxMum(int n, int m, int a, int b) {

        if(n < a) {return 0;}
        if(b >= m) {
            return n >= a ? a : 0;
        }
        return Math.min(n * b / a, m);
    }

    public static void main(String[] args) {
        Attack a = new Attack();
        a.attack();
    }
}
