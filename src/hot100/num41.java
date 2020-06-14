package hot100;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 * @author qian
 * @date 2020/1/18 10:51
 */
public class num41 {

    /**
     * 观看官方题解后详细解法理解如下：
     * 假设数组的长度是n，
     * 考虑一种极端的情况，数组中存放的依次是1~n这n个数（不保证是连续的，但是每个数字出现依次且仅仅一次），这种情况下问题的答案就是n+1。
     * 如果数组中出现了大于n的数字，那么答案必定是1~n这些数字中的一个，更极端的情况是数组中的元素全部大于n，那么答案明显就是1啦。
     * 所以说，对于大于n的数字还有小于等于0的数字都可以忽略不计，但是为了统一问题和后来使用正负号代表数字是否出现，我们将符合这些条件的数字都
     * 重置为1。但是在重置为1之前，需要检查整个数组中1是否出现过，如果没出现，答案直接是1；否则需要进一步判断。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length, i = 0;
        if (len == 0) {return 1;}
        // 检查1是否出现过
        for (i = 0; i < len; i++) {
            if (nums[i] == 1) {break;}
        }
        if (i == len) {return 1;}

        // 将大于len和小于等于0的数字重新置为1
        for (i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) { nums[i] = 1; }
        }

        // 现在数组中的元素的范围全在[1,n]之间
        // 用数组元素作为键，用数组元素的正(没出现过)负(出现过)号代表是否出现过
        int index = 0;
        for (i = 0; i < len; i++) {
            index = nums[i] - 1 >= 0 ? nums[i] - 1 : - nums[i] - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // 检查数组元素有大于0的吗
        for (i = 0; i < len; i++) {
            if (nums[i] > 0) {return i + 1;}
        }

        return len + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 0};
//        int[] nums = {3, 4, -1, 1};
        int[] nums = {7, 8, 9, 11, 13};

        num41 a = new num41();
        System.out.println(a.firstMissingPositive(nums));
    }
}
