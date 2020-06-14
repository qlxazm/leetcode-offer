package hot100;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class num34 {
    private int[] result = {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        binarySearch(nums, 0, nums.length - 1, target);
        return result;
    }


    public void binarySearch(int[] nums, int p, int q, int target) {
        int begin = p , end = q;

        // 升序版本的二分查找
        boolean flag = false;
        while (begin <= end && !flag) {
            int middle = (end + begin + 1) / 2;
            if (target > nums[middle]){
                begin = middle + 1;
            }else if (target < nums[middle]) {
                end = middle - 1;
            }else {
                if (middle == p || (middle > p && nums[middle - 1] < nums[middle])) {
                    result[0] = result[0] == -1 ? middle : result[0];
                }else {
                    binarySearch(nums, begin, middle - 1, target);
                }
                if (middle == q || (middle < q && nums[middle + 1] > nums[middle])){
                    result[1] = middle;
                }else {
                    binarySearch(nums, middle + 1, end, target);
                }
                // 提前终止
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        num34 a = new num34();
//        int[] nums = {5,7,7,8,8,10};
        int[] nums = {6};
        int target = 8;

        int[] result = a.searchRange(nums, 6);
        System.out.println(result[0] + ", " + result[1]);
    }
}
