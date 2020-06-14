package other;

/**
 * 大顶堆排序，实现从小到大
 */
public class HeapSort {

    public void headpSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[1];
            nums[1] = temp;
            adjuestDown(nums, 1, i);
        }
    }

    /**
     * 建立大顶堆
     * @param nums
     */
    private void buildHeap(int[] nums) {
        int len = nums.length;
        for(int i = len / 2; i > 0; i--) {
            adjuestDown(nums, i, len);
        }
    }

    /**
     * 从上到下进行调整
     * @param nums
     * @param i
     * @param len
     */
    private void adjuestDown(int[] nums, int i, int len) {
        nums[0] = nums[i];
        int k = 2 * i;
        for (; k < len; k *= 2) {
            // 右子树大于左子树
            if (k + 1 < len && nums[k + 1] > nums[k]) { k++; }
            if (nums[k] <= nums[0]) {
                break;
            }else {
                nums[k / 2] = nums[k];
            }
        }
        nums[k / 2] = nums[0];
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 8, 5, 2, 4, 7, 3, 6};

        HeapSort a = new HeapSort();
        a.headpSort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
