package hot100;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @author qian
 * @date 2020/1/21 9:04
 */
public class num103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode pre = root, p, lastChild = null;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            p = queue.poll();
            temp.add(p.val);
            if (p == pre) {
                if (p.right != null) {
                    pre = p.right;
                } else if (p.left != null) {
                    pre = p.left;
                } else {
                    pre = lastChild;
                }
                ans.add(temp);
                temp = new ArrayList<>();
            }
            if (p.left != null) {
                queue.offer(p.left);
                lastChild = p.left;
            }
            if (p.right != null) {
                queue.offer(p.right);
                lastChild = p.right;
            }
        }


        for (int i = 1, len = ans.size(); i < len; i += 2) {
            temp = ans.get(i);
            int l = 0, h = temp.size() - 1;
            while (l < h) {
                int n = temp.get(l);
                temp.set(l, temp.get(h));
                temp.set(h, n);
                l++;
                h--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        num103 a = new num103();

        /*TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;*/

//        List<List<Integer>> ans = a.zigzagLevelOrder(node3);

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        List<List<Integer>> ans = a.zigzagLevelOrder(node1);

       for (List<Integer> list : ans) {
           for (Integer num : list) {
               System.out.print(num + ", ");
           }
           System.out.println("");
       }
    }
}
