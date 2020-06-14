package hot100;

import structs.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class num141 {
    public boolean hasCycle(ListNode head) {
        /*Map<ListNode, Character> buffer = new HashMap<>();
        while (true) {
            if (head == null) {return false;}
            if (head.next != null && buffer.containsKey(head.next)) {return true;}
            buffer.put(head, (char)0);
            head = head.next;
        }*/

        ListNode p = head, q = head;
        do {
            if (q == null || q.next == null) {return false;}
            // q走两步
            q = q.next.next;
            // p走一步
            p = p.next;
        }while (q == null || q.next != p);
        return true;
    }

    public static void main (String[] args) {
        num141 a = new num141();

        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);

        node3.next = node2;
        node2.next = node0;
        node0.next = node_4;
        node_4.next = node2;

        System.out.println(a.hasCycle(node3));
    }
}
