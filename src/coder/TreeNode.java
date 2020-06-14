package coder;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void hierarchicalTraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.addLast(root);
        TreeNode p = null;
        while (!queue.isEmpty()) {
            p = queue.pollFirst();
            // 访问节点
            System.out.println(p.val);
            if (p.left != null) { queue.addLast(p.left); }
            if (p.right != null) {queue.addLast(p.right);}
        }
    }
}
