package algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * 思路： 建立正向索引和逆向索引
 *
 * 关键是 HashMap<Node, Node> map = new HashMap<>(); 建立映射关系
 */
public class num138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        // 为每个节点建立正向索引
        Node p = head, ans = new Node(0), tail = ans;
        while (p != null) {
            tail.next = new Node(p.val);
            tail = tail.next;
            map.put(p, tail);

            p = p.next;
        }

        // 调整random指针
        p = head;
        tail = ans.next;
        while (p != null) {
            tail.random = map.get(p.random);
            p = p.next;
            tail = tail.next;
        }

        return ans.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
