package hot100;

import structs.ListNode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class num19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode p, q;
        p = head;
        while (p != null && count < n) {
            p = p.next;
            count++;
        }

        ListNode r = head;
        q = head;
        while (p.next != null) {
            r = q;
            p = p.next;
            q = q.next;
        }

        // 删除第n个节点
        if (q == head) { return head.next; }
        r.next = q.next;
        return head;
    }

    public static void main(String[] args) {
        num19 a = new num19();

        ListNode head = new ListNode(-1);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        head.next = a1;
       /* a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;*/

        head = a.removeNthFromEnd(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
