package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yd
 * @date 2020/4/7 21:22
 */
public class ＭinHurt1 {

    static class Monster {
        int pofang;
        int shanghai;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int d = in.nextInt();
            Monster monsters[] = new Monster[n];
            for (int i = 0; i < n; i++) {
                monsters[i] = new Monster();
                monsters[i].pofang = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                monsters[i].shanghai = in.nextInt();
            }

            Arrays.sort(monsters, new Comparator<Monster>() {
                @Override
                public int compare(Monster o1, Monster o2) {
                    if (o1.pofang != o2.pofang) {
                        return o1.pofang - o2.pofang;
                    }
                    return o2.shanghai - o1.shanghai;
                }
            });

            int lo = 0;
            int hi = n - 1;
            int res = 0;
            while (lo <= hi) {
                if (monsters[lo].pofang < d) {
                    d++;
                    lo++;
                } else {
                    d++;
                    res += monsters[hi].shanghai;
                    hi--;

                }
            }
            System.out.println(res);
        }
    }
}
