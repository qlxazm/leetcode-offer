package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * @author qian
 * @date 2020/1/28 19:33
 */
public class num138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*public Node copyRandomList(Node head) {
        List<Node> buffer = new ArrayList<>();
        HashMap<Node, Integer> map = new HashMap<>();

        int index = 0;
        Node root = new Node(Integer.MIN_VALUE), nail = root, p = head, q;
        // 生成主链表
        while (p != null) {
            nail.next = new Node(p.val);
            buffer.add(nail.next);
            map.put(p, index);

            nail = nail.next;
            p = p.next;
            index++;
        }
        // 调整随机指针
        p = head;
        nail = root.next;
        while (p != null) {
            q = p.random;
            if (q != null) {
                nail.random = buffer.get(map.get(q));
            }
            nail = nail.next;
            p = p.next;
        }

        return root.next;
    }*/

    /*private HashMap<Node, Node> map = new HashMap<>();

    *//**
     * 回溯法
     * @param head
     * @return
     *//*
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node node = new Node(head.val);
        map.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
*/

    private HashMap<Node, Node> map = new HashMap<>();

    private Node getNode(Node p) {
        if (p != null) {
            if (!map.containsKey(p)) {
                map.put(p, new Node(p.val));
            }
            return map.get(p);
        }
        return null;
    }

    /**
     * 一次遍历
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {return null;}
        Node root = new Node(head.val), p = head;
        map.put(head, root);

        while (p != null) {
            root.next = getNode(p.next);
            root.random = getNode(p.random);

            p = p.next;
            root = root.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {

    }
}
