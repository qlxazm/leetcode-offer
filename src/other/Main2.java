package other;

/**
 * @author yd
 * @date 2020/4/15 16:27
 *
 * 一群人排成一圈，按1，2，...，n依次编号。然后从第1只开始数，
 * 数到第m个,把他踢出圈，从他后面再开始数，再数到第m个，
 * 在把他踢出去...，如此不停的进行下去，直到最后只剩下一个人为止，
 * 输入m、n,输出最后那个人的编号
 */
public class Main2 {

    public int lastMan(int m, int n) {
        boolean[] flags = new boolean[n + 1];
        int count = n;
        int i = 1;
        while (count > 1) {
            // 走m步
            int k = m;
            while (k > 0) {
                if (!flags[i]) {
                    k--;
                }
                i++;
                // 走到了最后一个
                if (i == n) {
                    i = 1;
                }
            }
            flags[i - 1] = true;
            count--;
        }
        return i;
    }


    /**
     * 堆排序
     * @param nums
     */
    public void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = nums.length - 1; i > 0; i--){
            System.out.println(nums[1]);
            nums[1] = nums[i];
            adjustDown(nums, 1, i);
        }
    }
    public void buildHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2; i >= 1; i--) {
            adjustDown(nums, i, len - 1);
        }
    }
    public void adjustDown(int[] nums, int k, int len) {
        nums[0] = nums[k];
        for (int i = 2 * k; i <= len; i = 2 * k) {
            // 左右子树中的最小值
            if (i < len && nums[i + 1] < nums[i]) {
                i++;
            }
            if (nums[i] >= nums[0]) {
                break;
            } else {
                nums[k] = nums[i];
                k = i;
            }

        }
        nums[k] = nums[0];
    }


    /**
     * 快速排序
     * @param nums
     * @param lower
     * @param high
     */
    public void fastSort(int[] nums, int lower, int high) {
        if (lower < high) {
            int index = partition(nums, lower, high);
            fastSort(nums, lower, index - 1);
            fastSort(nums, index + 1, high);
        }
    }
    public int partition(int[] nums, int lower, int high) {
        int pivot = nums[lower];
        while (lower < high) {
            while (high > lower && nums[high] >= pivot) {high--;}
            nums[lower] = nums[high];
            while (lower < high && nums[lower] <= pivot) {lower++;}
            nums[high] = nums[lower];
        }
        nums[lower] = pivot;
        return lower;
    }



    public int[] buffer = null;
    /**
     * 归并排序
     * @param nums
     */
    public void mergeSort(int[] nums) {
        int len = nums.length;
        buffer = new int[len];
        if (len > 0) {
            mergeSort(nums, 0, len - 1);
        }
    }
    public void mergeSort(int[] nums, int lower, int high) {
        if (lower < high) {
            int mid = (lower + high) / 2;
            // 先排序左半部分
            mergeSort(nums, lower, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, lower, mid, high);
        }
    }
    public void merge(int[] nums, int lower, int mid, int high) {
            for (int i = lower; i <= high; i++) {
                buffer[i] = nums[i];
            }
            // 开始归并
            int i = lower, j = mid + 1, k = lower;
            while (i <= mid && j <= high) {
                if (buffer[i] < buffer[j]) {
                    nums[k++] = buffer[i++];
                } else {
                    nums[k++] = buffer[j++];
                }
            }

            while (i <= mid) {
                nums[k++] = buffer[i++];
            }

            while (j <= high) {
                nums[k++] = buffer[j++];
            }
    }


    public static void main(String[] args) {
        Main2 main2 = new Main2();
//        System.out.println(main2.lastMan(3, 10));

        int[] nums = {0, 53, 17, 78, 9, 45, 65, 87, 32};
//        main2.heapSort(nums);

//        main2.fastSort(nums, 0, nums.length - 1);

        main2.mergeSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

        String s1 = "ab" + "cd";
        String s2 = "abc" + "d";
        System.out.println(s1 == s2);
    }
}
