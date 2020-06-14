package algorithm;

import structs.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class num113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        preOrder(root, ans, new LinkedList<>(), 0, sum);
        return ans;
    }

    public void preOrder(TreeNode root, List<List<Integer>> ans, List<Integer> path, int sum, int targer) {
        if (root == null) {return;}
        path.add(root.val);
        if (sum + root.val == targer) {
            ans.add(new LinkedList<>(path));
        } else {
            preOrder(root.left, ans, path, sum + root.val, targer);
            preOrder(root.right, ans, path, sum + root.val, targer);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node5_1 = new TreeNode(5);
        TreeNode node4_1 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5_2 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5_1.left = node4_1;
        node5_1.right = node8;

        node4_1.left = node11;

        node8.left = node13;
        node8.right = node4_2;

        node11.left = node7;
        node11.right = node2;

        node4_2.left = node5_2;
        node4_2.right = node1;

        num113 num113 = new num113();
        num113.pathSum(node5_1, 22);
    }
}
