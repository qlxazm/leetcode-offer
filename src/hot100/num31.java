package hot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * 要求下一种排列既要比原排列大，又不能有第三种排列位于他俩之间。即下一种排列为大于原排列的最小排列。
 *
 * 以输入为 358764 为例，字典序算法的步骤：
 * 1、从原排列中，从右至左，找到第一个左邻小于右邻的字符，记左邻位置为 a。
 * 示例中 a=1，list[a] = 5。
 * 2、重新从右至左，找到第一个比 list[a] 大的字符，记为位置为 b。
 * 示例中 b=4，list[b] = 6。
 * 3、交换 a 和 b 两个位置的值。
 * 示例变为了 368754。
 * 4、将 a 后面的数，由小到大排列。
 * 示例变为了 364578。
 *
 * 算法结束，输出 364578。
 *
 * 注意：
 * 1、第1步中，如果找不到左邻小于右邻的数，则说明给定的排列已经是全排列的最后一个排列了，则直接返回全排列的第一个排列，即所有排列中最小的排列，形成一个循环。
 * 2、在第3步交换前，a 后面的数是按照从大到小进行排列（否则第1步中就可以找到左邻小于右邻的数了）。
 * 3、在交换之后，a 后面的数仍然是按照从大到小排列的，尽管 b 位置的值变成了 list[a]，但是由于 b 位置是第一个比 list[a] 大的，因此交换之后 list[a] 仍然比左邻小，比右邻大。
 * 4、既然 a 后面的数是从大到小排列的，那么第4步的排序，直接将 a 后面的数倒序即可。
 *
 * 算法的时间复杂度为 O(n) + O(n) + O(n) = O(n)。
 * ————————————————
 * 版权声明：本文为CSDN博主「HappyRocking」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/happyrocking/article/details/83619392
 */
public class num31 {
    public void nextPermutation(int[] nums) {
        int left = 0, right = 0;
        // 找到第一个左邻小于右邻的数字
        for (left = nums.length - 2; left >= 0; left--) {
            if (compareTo(nums[left], nums[left + 1]) < 0) {
                break;
            }
        }
        if (left >= 0) {
            for (right = nums.length - 1; right >= 0; right--) {
                if (compareTo(nums[right], nums[left]) > 0) {break;}
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        reverseArray(nums, left + 1, nums.length - 1);
    }


    /*public void nextPermutation(int[] nums) {
        int i = 0, j = 0, k = 0, m = 0;
        int left = 0, right = 0;

        //找到所有符合 nums[j] < nums[i] 的数对， 比较谁最靠右
        for (i = nums.length - 1; i > 0; i--) {
            for (j = i - 1; j >= 0; j--) {
                if (compareTo(nums[j], nums[i]) < 0) {
                    if (j > left || (j == left && i > right)){
                        left = j;
                        right = i;
                    }
                }
            }
        }

        System.out.println("符合条件的left: " + left + " ,值是: " + nums[left]);
        System.out.println("符合条件的left: " + right + " ,值是: " + nums[right]);

        if (right > 0) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            // 为nums[i]找到一个合适的地方
            for (k = left + 1; k < nums.length; k++) {
                if (compareTo(temp, nums[k]) > 0) { break; }
            }
            k--;
            if (k > right) {
                for (j = right; j < k; j++) {
                    nums[j] = nums[j + 1];
                }
            }else if (k < right) {
                for (j = k; j < right; j++) {
                    nums[j + 1] = nums[j];
                }
            }
            nums[k] = temp;
            reverseArray(nums, left + 1, nums.length - 1);
        }else {
            reverseArray(nums, 0, nums.length - 1);
        }
    }*/

    public void reverseArray(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[end];
            nums[end] = nums[begin];
            nums[begin] = temp;
            begin++;
            end--;
        }
    }


    public int compareTo(int a, int b) {
        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);
        int aLen = aStr.length(), bLen = bStr.length(), i, len;
        if (aLen == bLen) { return a - b; }

        for (i = 0, len = Math.min(aLen, bLen); i < len; i++) {
            int temp = aStr.charAt(i) - bStr.charAt(i);
            if (temp != 0) {return temp;}
        }

        return i == aLen ? -1 : 1;
    }


    public void nextPermutation1(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        // 找到第一个逆序对
        while (i >= 0 && nums[i + 1] <= nums[i]) {i--;}
        if (i >= 0) {
            int j = len - 1;
            // 找到第一个大于nums[i]的数
            for (; j > i; j--) {
                if (nums[j] > nums[i]) {break;}
            }
            // 交换
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
        // 升序排列部分数组
        Arrays.sort(nums, i + 1, len);
    }

    public void print(List<? extends Number> list) {
        for (Number num: list) {
            System.out.print(num);
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        num31 a = new num31();
//        int[] nums = {1, 2, 3};
//        int[] nums = {3, 2, 1};
//        int[] nums = {1, 1, 5};
//        int[] nums = {1,3, 2};
//        int[] nums = {2,2,7,5,4,3,2,2,1};
//        int[] nums = {4,2,0,2,3,2,0};
//        int[] nums = {4,0,5,29,14,16,9,2,12,14,7,27,15,4,8,11,2,18,29,3,16,8,10,22,11,10,15,1,1,0,28,5,0,26,4,6,12,5,8,16,12,8,14,27,12,14,0,6,2,29,9,10,8,11,3};
        int[] nums = {8, 11, 3, 1, 2, 10,7};
        /*a.nextPermutation(nums);

        int b = 11;
        int c = 3;
        System.out.println(a.compareTo(b, c));


        for (int i = 0, len = nums.length; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
*/
        Object o = new Object();
        HashSet<Integer> objects = new HashSet<>();
        System.out.println(objects.add(null));
        System.out.println(objects.add(null));
        System.out.println(objects.contains(null));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        a.print(list1);

        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        System.out.println(l1.getClass() == l2.getClass());

        List<? super Integer> l3 = new ArrayList<>();
        l3.add(new Integer(2));
    }
}
