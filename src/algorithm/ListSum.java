package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class ListSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode p = l1, q = l2;
        ListNode tail = head;

        // 进位
        int f = 0;
        while (p != null && q != null) {
            int k = p.val + q.val + f;
            tail.next = new ListNode(k % 10);
            tail = tail.next;
            f = k / 10;

            p = p.next;
            q = q.next;
        }

        while (p != null) {
            int k = p.val + f;
            tail.next = new ListNode(k % 10);
            tail = tail.next;
            f = k / 10;
            p = p.next;
        }

        while (q != null) {
            int k = q.val + f;
            tail.next = new ListNode(k % 10);
            tail = tail.next;
            f = k / 10;
            q = q.next;
        }

        if (f > 0) {
            tail.next = new ListNode(f);
            tail = tail.next;
        }

        return head.next;
    }
}
