package recruite;

import java.util.Scanner;

/**
 * @author yd
 * @date 2020/3/27 20:41
 */
public class Max {

    double ans = 0;

    public void max() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = 0;
        int[] nums = new int[N];
        int i = 0;
        while (i < N) {
            nums[i] = scanner.nextInt();
            if (nums[i] == 2) {M++;}
            i++;
        }
        max(nums, 0, N);
        System.out.println(String.format("%.5f", ans / Math.pow(2, M)));
    }

    public void max(int[] nums, int start, final int N) {
        int k = 0, i = start, j = 0;
        while (i < N && nums[i] != 2) {
            if (nums[i] == 0) {
                j = 0;
            } else {
                j++;
                k += j;
            }
            i++;
        }

        // 加班
        j = i - 1;
        while (nums[j] == 1) {j--;}
        k += j - i + 1;
        ans += k;
        nums[i] = 1;
        max(nums, i + 1, N);
        // 不加班
        nums[i] = 0;
        max(nums, i + 1, N);
    }
}
