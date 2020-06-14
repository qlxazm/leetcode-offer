package hot100;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class num215 {
    public int findKthLargest(int[] nums, int k) {
        int[] minHeap = new int[k + 1];
        for (int i = 1; i <= k; i++) {minHeap[i] = nums[i - 1];}

        // 建立小顶堆
        buildMinHeap(minHeap);

        for (int i = k, len = nums.length; i < len; i++) {
            if (minHeap[1] <= nums[i]) {
                minHeap[1] = nums[i];
                adjustDown(minHeap, 1);
            }
        }
        return minHeap[1];
    }

    /**
     * 建堆
     * @param nums
     */
    private void buildMinHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 1; i--) {
            adjustDown(nums, i);
        }
    }

    /**
     * 从k开始从上到小调整小顶堆
     * @param nums
     * @param k
     */
    private void adjustDown(int[] nums, int k) {
        nums[0] = nums[k];
        for (int i = 2 * k, len = nums.length; i < len; i *= 2) {
            // 计算左右子树中谁比较小
            if (i + 1 < len && nums[i] > nums[i + 1]){
                i++;
            }
            if (nums[0] > nums[i]) {
                nums[k] = nums[i];
                k = i;
            }else {
                break;
            }
        }
        nums[k] = nums[0];
    }

    public static void main(String[] args) {
        num215 a = new num215();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.print(a.findKthLargest(nums, 2));

       /* int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.print(a.findKthLargest(nums, 4));*/

    }
}
