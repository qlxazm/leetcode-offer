package coder;

import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class num108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int low, int high) {
        TreeNode root = null;
        if (low <= high) {
            int rootIndex = (low + high + 1) / 2;
            root = new TreeNode(nums[rootIndex]);
            root.left = createTree(nums, low, rootIndex - 1);
            root.right = createTree(nums, rootIndex + 1, high);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        num108 a = new num108();
        TreeNode.hierarchicalTraversal(a.sortedArrayToBST(nums));
    }
}
