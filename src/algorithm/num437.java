package algorithm;

import structs.TreeNode;

/**
 */
public class num437 {

    private int ans = 0;
    private int target;

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        preOrder(root, new int[0]);
        return ans;
    }

    private void preOrder(TreeNode root, int[] sums) {
        if (root == null) {return;}
        int[] nextSum = new int[sums.length + 1];
        for (int i = 0, len = sums.length; i < len; i++) {
            if ((nextSum[i] = sums[i] + root.val) == target) {
                ans++;
            }
        }
        if ((nextSum[sums.length] = root.val) == target) {ans++;}

        preOrder(root.left, nextSum);
        preOrder(root.right, nextSum);
    }

}
