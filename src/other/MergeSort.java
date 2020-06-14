package other;

/**
 * 归并排序
 */
public class MergeSort {

    private int[] buffer;
    public void mergeSort(int[] nums) {
        int len = nums.length;
        buffer = new int[len];
        mergeSort(nums, 0, len - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(nums, start, middle);
            mergeSort(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int i, j, k;
        for (k = start; k <= end; k++) {buffer[k] = nums[k];}

        for (i = start, j = middle + 1, k = start; i <= middle && j <= end; k++) {
            if (buffer[i] <= buffer[j]) {
                nums[k] = buffer[i++];
            }else {
                nums[k] = buffer[j++];
            }
        }
        while (i <= middle) {nums[k++] = buffer[i++];}
        while (j <= end) {nums[k++] = buffer[j++];}
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 8, 5, 2, 4, 7, 3, 6};

        MergeSort a = new MergeSort();
        a.mergeSort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
