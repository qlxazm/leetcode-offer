package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class SplitList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(Integer.MAX_VALUE);
        ListNode right = new ListNode(Integer.MAX_VALUE);

        ListNode p = null;
        while (head != null) {
            p = head;
            head = head.next;
            if (p.val < x) {
                p.next = left.next;
                left.next = p;
            } else {
                p.next = right.next;
                right.next = p;
            }
        }

        p = left;
        while (p.next != null) {p = p.next;}
        p.next = right.next;
        return left.next;
    }
}
