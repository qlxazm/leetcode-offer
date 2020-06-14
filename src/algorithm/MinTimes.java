package algorithm;

import structs.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 */
public class MinTimes {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        n = 2 * n;
        int[] nums = new int[n];
        int i = 0;
        for (i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // 记录某个元素出现的位置
        int[] buffer = new int[n];
        for (i = 0; i < n; i++) {
            buffer[nums[i]] = i;
        }

        int ans = 0;
        for (i = 0; i < n - 1; i += 2) {
            // 如果无序
            if (Math.abs(nums[i] - nums[i + 1]) != 1) {
                int target = (nums[i] & 1) == 0 ? nums[i] + 1 : nums[i] - 1;
                int targetIndex = buffer[target];
                // 交换
                nums[i + 1] = nums[i + 1] ^ nums[targetIndex];
                nums[targetIndex] = nums[i + 1] ^ nums[targetIndex];
                nums[i + 1] = nums[i + 1] ^ nums[targetIndex];
                ans++;
            }
        }

        System.out.println(ans);
    }
}
