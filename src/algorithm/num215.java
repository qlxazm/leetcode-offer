package algorithm;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 */
public class num215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
                continue;
            }
            if (num >= minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }


    /**
     * 建立小顶堆
     * @param nums
     */
    public void buildHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2; i >= 1; i--) {
            adjustDown(nums, i, len);
        }
    }

    public void adjustDown(int[] nums, int k, int len) {
        nums[0] = nums[k];
        while (k < len) {
            int i = 2 * k;
            // 两者中的最小值
            if (i < len - 1 && nums[i] > nums[i + 1]) {
                i++;
            }
            if (nums[0] < nums[i]) {
                nums[k] = nums[0];
                break;
            } else {
                nums[k] = nums[i];
                k = i;
            }
        }
    }

    public void adjustUp(int[] nums, int k) {

    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 1, 5, 6, 4};
        num215 num215 = new num215();
        num215.buildHeap(nums);
        int a = (int)Math.pow(2, 3);
        System.out.println(a);
//        System.out.println(num215.findKthLargest(nums, 2));
        LinkedList<Integer> objects = new LinkedList<>();
        System.out.println(Double.valueOf("2.111d1"));
    }
}
