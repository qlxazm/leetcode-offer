package recruite;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class Area {

    public void area() {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        double ans = 0;
        int i = n - 1;
        boolean isBlack = true;
        for (; i >= 0; i--) {
            if (isBlack) {
                ans += Math.PI * nums[i] * nums[i];
                isBlack = false;
            }else {
                ans -= Math.PI * nums[i] * nums[i];
                isBlack = true;
            }
        }

        System.out.println(String.format("%.5f", ans));
    }

    public static void main(String[] args) {
        Area a = new Area();
        a.area();
    }
}
