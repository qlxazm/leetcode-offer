package hot100;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 这个题目是寻找有环链表 环的交点的数组形式。
 *  关键是理解 =============环的入口就是要寻找的重复出现的元素============================
 *  比如有以下用例：
 *
 *  0 1 2 3 4 5 6
 *  1 4 6 6 5 2 3
 *
 *  3=>6,6=>3形成了一个环
 *  2=>6,3=>6就定义了环的交点
 */
public class num287 {
    public int findDuplicate(int[] nums) {
        // 1、第一步，先找到环
        int fast, slow;
        fast = slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }while (fast != slow);
        // 2、统计环的长度
        int cycleLength = 1;
        fast = nums[fast];
        while (slow != fast){cycleLength++;fast = nums[fast];}
        // 3、寻找环的入口
        fast = slow = nums[0];
        while (cycleLength > 0) {fast = nums[fast];cycleLength--;}
        while (fast != slow){ fast = nums[fast];slow = nums[slow];}
        return slow;
    }

    public static void main(String[] args) {
        num287 a = new num287();
//        int[] nums = {1,3,4,2,2};
        int[] nums = {3,1,3,4,2};
        System.out.print(a.findDuplicate(nums));
    }
}
