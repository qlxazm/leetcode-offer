package algorithm;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/successor-lcci/
 */
public class Successor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode[] buffer = new TreeNode[2];
        inorder(root, p, buffer);
        return buffer[1];
    }

    /**
     *
     * @param root
     * @param p
     * @param buffer
     * @return 表示是否在这个子树上计算出来了结果
     */
    public boolean inorder(TreeNode root, TreeNode p, TreeNode[] buffer) {
        if (root == null) {return false;}
        if (inorder(root.left, p, buffer)) {
            return true;
        }

        buffer[0] = buffer[1];
        buffer[1] = root;
        if (buffer[0] == p) { return true; }

        return inorder(root.right, p, buffer);
    }

    /**
     * 二叉树非递归中序遍历
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode q = root, last = null;
        while (!queue.isEmpty() || q != null) {
            while (q != null) {
                queue.offer(q);
                q = q.left;
            }
            //访问节点
            q = queue.pollLast();
            if (last == p) {return q;}
            last = q;
            q = q.right;
        }
        return null;
    }

    public void levelTrace(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        TreeNode last = root, p = null, q = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            while (!queue.isEmpty()) {
                p = queue.poll();
                buffer.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                    q = p.left;
                }
                if (p.right != null) {
                    queue.offer(p.right);
                    q = p.right;
                }
                // 换成下一层
                if (last == p) {
                    last = q;
                    buffer = new ArrayList<>();
                }
            }
        }
    }

    public static void main(String[] args) {
       TreeNode node1 = new TreeNode(1);
       TreeNode node2 = new TreeNode(2);
       TreeNode node3 = new TreeNode(3);

       node2.left = node1;
       node2.right = node3;

        Successor successor = new Successor();
        TreeNode ans = successor.inorderSuccessor1(node2, node1);
        System.out.println(ans.val);
    }
}
