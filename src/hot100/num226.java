package hot100;

import structs.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class num226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tempLeft = invertTree(root.left);
            TreeNode tempRight = invertTree(root.right);
            root.right = tempLeft;
            root.left = tempRight;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
