package other;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class MinTicket {

    public int minTicket() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        boolean[] visited = new boolean[n];

        int m = 0;
        while (m < n) {
            nums[m][0] = scanner.nextInt();
            nums[m][1] = scanner.nextInt();
            m++;
        }


        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int ans = 0;
        int i = 0;
        while (i < n) {
            if (!visited[i]) {
                int lastStation = nums[i][1];
                visited[i] = true;
                for (int j = i + 1; j < n; j++) {
                    if (!visited[j] && lastStation <= nums[j][0]) {
                        lastStation = nums[j][1];
                        visited[j] = true;
                    }
                }
                ans++;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinTicket minTicket = new MinTicket();
        System.out.println(minTicket.minTicket());
    }
}
