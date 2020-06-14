package hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * @author qian
 * @date 2020/1/6 15:03
 */
public class num494 {

    /*方法1：使用递归 */
    /*private int len;
    private int target;
    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        len = nums.length;
        target = S;
        if (len > 0) {
            findTargetSumWays(nums, 0, 0);
        }
        return count;
    }

    public void findTargetSumWays(int[] nums, int nextIndex, int tempSum) {
        if (nextIndex + 1 == len) {
            if (tempSum + nums[nextIndex] == target) {count++;}
            if (tempSum - nums[nextIndex] == target) {count++;}
        }else {
            findTargetSumWays(nums, nextIndex + 1, tempSum - nums[nextIndex]);
            findTargetSumWays(nums, nextIndex + 1, tempSum + nums[nextIndex]);
        }
    }*/

    /*
    * 方法2：将上面递归形式的代码改成非递归
    * 这种方法的效率，还不如递归
    * */
/*    public int findTargetSumWays(int[] nums, int S) {
        Stack<Integer> tempSumStack = new Stack<>();
        Stack<Integer> nextIndexStack = new Stack<>();

        tempSumStack.push(0);
        nextIndexStack.push(0);
        int tempSum, nextIndex, len = nums.length, count = 0;
        while (!nextIndexStack.isEmpty()) {
            tempSum = tempSumStack.pop();
            nextIndex = nextIndexStack.pop();

            if (nextIndex + 1 == len) {
                if (tempSum + nums[nextIndex] == S) {count++;}
                if (tempSum - nums[nextIndex] == S) {count++;}
            }else {
                tempSumStack.push(tempSum + nums[nextIndex]);
                tempSumStack.push(tempSum - nums[nextIndex]);
                nextIndexStack.push(nextIndex + 1);
                nextIndexStack.push(nextIndex + 1);
            }
        }
        return count;
    }*/

    /*
    * 内存优化了的动态规划
    * 属于0-1背包问题
    * */
    public int findTargetSumWays(int[] nums, int S) {

        if (S > 1000 || S < -1000) {return 0;}

        int len = nums.length;
        int[] dp = new int[2001];

        // 初始化
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;


        for (int i = 1; i < len; i++) {
            int num = nums[i];
            int[] next = new int[2001];
            for (int j = -1000; j <= 1000; j++) {
                if (j - num >= -1000 && j - num <= 1000) {
                    next[j + 1000] += dp[j - num + 1000];
                }

                if (j + num >= -1000 && j + num <= 1000) {
                    next[j + 1000] += dp[j + num + 1000];
                }
            }
            // 滚动数组，优化内存空间
            dp = next;
        }

        return dp[S + 1000];
    }

    public static void main(String[] args) {
        num494 a = new num494();
//        int[] nums = {1,1,1,1,1};
//        int S = 3;

//        int[] nums = {1};
//        int S = 1;

        int[] nums = {1, 0};
        int S = 1;

        System.out.print(a.findTargetSumWays(nums, S));
    }
}
