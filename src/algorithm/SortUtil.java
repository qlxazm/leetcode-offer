package algorithm;

/**
 */
public class SortUtil {

    public void fastSort(int[] nums) {
        fastSort(nums, 0, nums.length -1);
    }

    public void fastSort(int[] nums, int i, int j) {
        if(i < j) {
            int pivot = partition(nums, i, j);
            fastSort(nums, i, pivot - 1);
            fastSort(nums, pivot + 1, j);
        }
    }

    public int partition(int[] nums, int i, int j) {
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {j--;}
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {i++;}
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    private int[] buffer;
    public void mergeSort(int[] nums) {
        buffer = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(nums, i, mid);
            mergeSort(nums, mid + 1, j);
            merge(nums, i, mid, j);
        }
    }

    public void merge(int[] nums, int lower, int mid, int hight) {
        if (lower < hight) {
            for (int i = lower; i <= hight; i++) {
                buffer[i] = nums[i];
            }
            int i = lower, j = mid + 1, k = lower;
            while (i <= mid && j <= hight) {
                if (buffer[i] < buffer[j]) {
                    nums[k] = buffer[i];
                    i++;
                } else {
                    nums[k] = buffer[j];
                    j++;
                }
                k++;
            }

            while (i <= mid) {
                nums[k++] = buffer[i++];
            }

            while (j <= hight) {
                nums[k++] = buffer[j++];
            }
        }
    }

}
