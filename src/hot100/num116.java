package hot100;

import structs.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * @author qian
 * @date 2020/1/21 10:04
 */
public class num116 {

    /**
     * 层次遍历
     * @param root
     * @return
     */
    /*public Node connect(Node root) {

        Queue<Node> queue = new LinkedList<>();
        Node p, last = root, pre = null;

        if (root != null) { queue.offer(root); }

        while (!queue.isEmpty()) {
            p = queue.poll();
            if (pre != null) { pre.next = p; }
            pre = p;
            if (p == last) {
                pre = null;
                last = p.right;
            }
            if (p.left != null) { queue.offer(p.left); }
            if (p.right != null) { queue.offer(p.right); }

        }

        return root;
    }*/

    public Node connect(Node root) {
        if (root != null) {
            preOrderConnect(root);
        }
        return root;
    }

    private void preOrderConnect(Node root) {
        // 叶子节点直接返回
        if (root.left == null && root.right == null) {
            return ;
        }
        root.left.next = root.right;

        Node pre = root.left, next = root.right;
        while (pre.right != null) {
            pre = pre.right;
            next = next.left;
            pre.next = next;
        }

        preOrderConnect(root.left);
        preOrderConnect(root.right);
    }

    public static void main(String[] args) {

    }
}
