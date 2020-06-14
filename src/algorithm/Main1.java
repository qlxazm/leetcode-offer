package algorithm;

import java.util.Scanner;

/**
 */
public class Main1 {

    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        String[] strArray1 = scanner.nextLine().split(",");
        String[] strArray2 = scanner.nextLine().split(",");
        int[] a = new int[strArray1.length];
        int[] b = new int[strArray2.length];
        int i = 0, j = 0;
        for (String s : strArray1) {a[i++] = Integer.valueOf(s);}
        i = 0;
        for (String s : strArray2) {b[i++] = Integer.valueOf(s);}

        if (strArray1.length == 0 || strArray2.length == 0) {
            System.out.println(0);
            return;
        }

        int ans = 1;
        while (true) {
            boolean[] buffer = new boolean[1000];
            // 对于每个路灯
            for (int num : b) {
                i = Math.max(0, num - ans);
                j = Math.min(num + ans, 999);
                for (;i <= j; i++) {buffer[i] = true;}
            }
            // 检测是否全部覆盖
            for (i = 0; i < a.length; i++) {
                if (!buffer[a[i]]) {break;}
            }
            if (i == a.length) {
                System.out.println(ans);
                break;
            }
            ans++;
        }
    }
}
