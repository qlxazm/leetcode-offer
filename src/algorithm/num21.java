package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class num21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tail = head, p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p = l1;
                l1 = l1.next;
            } else {
                p = l2;
                l2 = l2.next;
            }
            p.next = null;
            tail.next = p;
            tail = p;
        }

        while (l1 != null) {
            p = l1;
            l1 = l1.next;
            p.next = null;
            tail.next = p;
            tail = p;
        }

        while (l2 != null) {
            p = l2;
            l2 = l2.next;
            p.next = null;
            tail.next = p;
            tail = p;
        }

        return head.next;
    }
}
