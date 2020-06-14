package algorithm;


import structs.TreeNode;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class num337 {

    public int rob(TreeNode root) {
        int[] ans = maxProfit(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] maxProfit(TreeNode root) {
        int[] ans = {0, 0};
        if (root == null) {return ans;}
        int[] left = maxProfit(root.left);
        int[] right = maxProfit(root.right);
        // 选择root
        ans[0] = left[1] + right[1] + root.val;
        // 不选择root
        ans[1] = left[0] + right[0];
        ans[1] = Math.max(ans[1], left[0] + right[1]);
        ans[1] = Math.max(ans[1], left[1] + right[0]);
        ans[1] = Math.max(ans[1], left[1] + right[1]);

        return ans;
    }
}
