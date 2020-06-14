package hot100;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class num102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int size = 1, count = 0, buffer = 0;

        // 根节点入队
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            // 出队
            TreeNode p = queue.poll();
            temp.add(p.val);
            count++;

            if (p.left != null) {
                queue.offer(p.left);
                buffer++;
            }
            if (p.right != null) {
                queue.offer(p.right);
                buffer++;
            }

            // 换下一行
            if (count == size) {
                size = buffer;
                count = buffer = 0;
                result.add(temp);
                temp = new ArrayList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        num102 a = new num102();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

      /* TreeNode node1 = new TreeNode(1);
       TreeNode node2 = new TreeNode(2);
       TreeNode node3 = new TreeNode(3);
       TreeNode node4 = new TreeNode(4);
       TreeNode node5 = new TreeNode(5);

       node1.left = node2;
       node1.right = node3;

       node2.left = node4;
       node2.right = node5;*/

        System.out.println(a.levelOrder(node3));
    }
}
