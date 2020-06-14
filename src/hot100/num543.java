package hot100;

import structs.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @author qian
 * @date 2020/1/6 20:57
 */
public class num543 {

    private int longest = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            longestPath(root);
        }
        return longest;
    }

    private int longestPath(TreeNode root) {
        int leftLongest = 0;
        int rightLongest = 0;

        if (root.left != null) {
            leftLongest = longestPath(root.left) + 1;
        }

        if (root.right != null) {
            rightLongest = longestPath(root.right) + 1;
        }

        longest = Math.max(longest, leftLongest + rightLongest);
        return Math.max(leftLongest, rightLongest);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        num543 a = new num543();
        System.out.print(a.diameterOfBinaryTree(node1));
    }
}
