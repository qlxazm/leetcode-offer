package recruite;

import java.util.Scanner;

/**
 */
public class Interst {

    public void interst() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i = 0;
        int[] nums = new int[n];
        while (i < n) {
            nums[i] = scanner.nextInt();
            i++;
        }
    }
}
