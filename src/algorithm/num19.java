package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class num19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;
        ListNode fast = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null && k > 0) {return null;}
        ListNode slower = head, pre = null;
        while (fast != null) {
            pre = slower;
            slower = slower.next;
            fast = fast.next;
        }
        // 删除头结点
        if (slower == head) {
            return slower.next;
        } else {
            pre.next = slower.next;
        }
        return head;
    }

}
