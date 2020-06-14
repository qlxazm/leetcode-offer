package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class ListJoin {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode p;
        int lenA = 0;
        int lenB = 0;

        p = headA;
        while (p != null) {
            p = p.next;
            lenA++;
        }
        p = headB;
        while (p != null) {
            p = p.next;
            lenB++;
        }

        p = headA;
        ListNode q = headB;

        while (lenA > lenB) {
            p = p.next;
            lenA--;
        }
        while (lenB > lenA) {
            q = q.next;
            lenB--;
        }

        while (p != null && q != null) {
            if (p == q) {return p;}
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
