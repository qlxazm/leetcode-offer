package hot100;

import structs.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class num104 {

    /*public int maxDepth(TreeNode root) {
        if (root == null) {return 0;}
        return Math.max(maxDepth(root.left), maxDepth( root.right)) + 1;
    }*/


    /*public int maxDepth(TreeNode root) {
        return 0;
    }*/

    /*private int max = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return max;
    }

    public void maxDepth(TreeNode root, int depth) {
        if (root != null) {
            max = Math.max(max, depth + 1);
            maxDepth(root.left, depth + 1);
            maxDepth(root.right, depth + 1);
        }
    }*/


    /**
     * 层次遍历的方法实现
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root != null) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode last = root, temp = root;
            queue.addLast(root);
            while (!queue.isEmpty()) {
                root = queue.pollFirst();
                if (root.left != null) {
                    temp = root.left;
                    queue.addLast(root.left);
                }
                if (root.right != null) {
                    temp = root.right;
                    queue.addLast(root.right);
                }

                if (root == last) {
                    last = temp;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        num104 a = new num104();

        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        System.out.println(a.maxDepth(node3));
    }
}
