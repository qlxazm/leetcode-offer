package recruite;

import java.util.Scanner;

/**
 */
public class LengthPath {

    public void lengthPath() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int[] nums = new int[n];
        while (i < n) {
            nums[i++] = scanner.nextInt();
        }
        int[][] points = new int[n - 1][2];
        i = 0;
        while (i < n - 1) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
            i++;
        }
    }
}
