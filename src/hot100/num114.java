package hot100;

import structs.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class num114 {
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {return ;}
        if (root.left != null) { flatten(root.left); }
        TreeNode p = root.left;
        while (p != null) {
            if (p.right == null) {break;}
            p = p.right;
        }
        if (root.right != null) { flatten(root.right); }
        if (p != null) {
            p.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public static void main() {

    }
}
