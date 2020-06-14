package other;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 合并有序链表
 */
public class MergeList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode head = new ListNode(-1), tail = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                tail.next = p;
                tail = p;
                p = p.next;
            }else {
                tail.next = q;
                tail = q;
                q = q.next;
            }
        }
        while (p != null) {
            tail.next = p;
            tail = p;
            p = p.next;
        }
        while (q != null) {
            tail.next = q;
            tail = q;
            q = q.next;
        }
        return head.next;
    }

}
