package other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 */
public class MinHurt {

    static class Pair{
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void minHurt() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int D = scanner.nextInt();

        // 输入防御力
        Pair[] pairs = new Pair[n];
        int i = 0;
        while (i < n) {
            pairs[i++] = new Pair(scanner.nextInt(), 0);
        }
        // 输入伤害力
        i = 0;
        while (i < n) {
            pairs[i++].value = scanner.nextInt();
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1.key != o2.key){
                    return o1.key - o2.key;
                } else {
                    return o2.value - o1.value;
                }
            }
        });

        int ans = 0;
        i = 0;
        // 计算防御力
        while (i < n) {
            if (pairs[i].key >= D) {
                ans += pairs[n - 1].value;
                n--;
            } else {
                i++;
            }
            D++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        MinHurt a = new MinHurt();
        a.minHurt();
    }
}
