package hot100;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class num33 {
    public int search(int[] nums, int target) {
        int i = 0, len = nums.length;
        if (len == 0) {return 0;}
        if (len == 1) {return nums[0] == target ? 0 : -1;}
        for (;i < len - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                break;
            }
        }

        return Math.max(binarySearchAsc(nums, 0, i, target), binarySearchAsc(nums, i + 1, len - 1, target));



        /*int begin = 0, len = nums.length, end = len - 1, middle;

        while (begin < end) {
            middle = (end + begin + 1) / 2;

            if (middle < len - 1 && nums[middle + 1] < nums[middle]) {
                //左侧部分最靠右边的一个数
                if (target > nums[middle]) {
                    return -1;
                }else if (target < nums[middle]){
                    int temp = binarySearchAsc(nums, begin, middle - 1, target);
                    return Math.max(binarySearchAsc(nums, middle + 1, end, target), temp);
                }else {
                    return middle;
                }

            }else if (middle > 0 && nums[middle - 1] > nums[middle]) {
                //右侧部分最靠左的一个
                if (target < nums[middle]) {
                    return -1;
                }else if (target > nums[middle]){
                    int temp = binarySearchAsc(nums, middle + 1, end, target);
                    return Math.max(binarySearchAsc(nums, begin, middle - 1, target), temp);
                }else {
                    return middle;
                }
            }else {
                if (target < nums[middle]) {
                    return binarySearchAsc(nums, begin, middle - 1, target);
                }else if (target > nums[middle]){

                }else {
                    return middle;
                }
            }
        }


        return 0;*/
    }

    /*public int binarySearchDesc(int[] nums, int begin, int end, int n) {
        // 降序版本的二分查找
        int result = -1;
        while (begin < end) {
            int middle = (end + begin + 1) / 2;
            if (n > nums[middle]){
                end = middle - 1;
            }else if (n < nums[middle]) {
                begin = middle + 1;
            }else {
                result = middle;
                break;
            }
        }
        return 0;
    }*/

    public int binarySearchAsc(int[] nums, int begin, int end, int n) {
        // 升序版本的二分查找
        int result = -1;
        while (begin <= end) {
            int middle = (end + begin + 1) / 2;
            if (n > nums[middle]){
                begin = middle + 1;
            }else if (n < nums[middle]) {
                end = middle - 1;
            }else {
                result = middle;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        num33 a = new num33();
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1,2,3,4,5};
        int target = 0;
//        System.out.println(a.binarySearchAsc(nums, 0, nums.length - 1, 0));
        System.out.println(a.search(nums, target));
    }
}
