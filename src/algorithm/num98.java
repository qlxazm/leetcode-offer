package algorithm;

import structs.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class num98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) { return true; }

        if (!isValidBST(root.left)) {return false;}
        TreeNode p = root.left;
        while (p != null) {
            if (p.val > root.val) {return false;}
            p = p.right;
        }

        if (!isValidBST(root.right)) {return false;}
        p = root.right;
        while (p != null) {
            if (p.val < root.val) {return false;}
            p = p.left;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node1_2 = new TreeNode(1);
        node1_1.left = node1_2;

        num98 num98 = new num98();
        System.out.println(num98.isValidBST(node1_1));
    }
}
