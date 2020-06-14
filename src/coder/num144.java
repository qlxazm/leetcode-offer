package coder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num144 {
    /**
     * 非递归前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.empty() || root != null) {
            while (root != null) {
                //访问根节点
                results.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return results;
    }

    /**
     * 前序遍历（递归形式）
     * @param root
     * @param list
     */
    private void PreOrder(TreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.val);
            PreOrder(root.left, list);
            PreOrder(root.right, list);
        }
    }

    public static void main(String[] args) {
        num144 a = new num144();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.right = node2;
        node2.left = node3;
        node1.left = node4;
        List<Integer> list = a.preorderTraversal(node1);

        for (int i = 0, len = list.size(); i < len; i++) {
            System.out.print(list.get(i) + ",");
        }
    }
}
