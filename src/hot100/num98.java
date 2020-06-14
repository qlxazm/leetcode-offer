package hot100;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class num98 {
    /*public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        boolean flag = false;
        int before = 0;
        while (!stack.empty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (!flag) {
                flag = true;
                before = p.val;
            }else if (before >= p.val){
                return false;
            }
            before = p.val;
            p = p.right;
        }
        return true;
    }*/

    /*public boolean isValidBST(TreeNode root) {
        if (root == null) {return true;}
        boolean result = isValidBST(root.left) && isValidBST(root.right);
        if (!result) { return false;}
        // 大于左子树的最大值
        TreeNode p = root.left;
        while (p != null) {
            result = result && p.val < root.val;
            p = p.right;
        }
        if (!result) {return false;}
        // 小于右子树的最小值
        p = root.right;
        while (p != null) {
            result = result && p.val > root.val;
            p = p.left;
        }
        return result;
    }*/

    public boolean isValidBST(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node4 = new TreeNode(15);
        TreeNode node3 = new TreeNode(6);
        TreeNode node6 = new TreeNode(20);

        node5.left = node1;
        node5.right = node4;

        node4.left = node3;
        node4.right = node6;

        num98 a = new num98();
        System.out.println(a.isValidBST(node5));
    }
}
