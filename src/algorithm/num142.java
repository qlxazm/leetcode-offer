package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class num142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        // 判断是否有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {break;}
        }

        // 无环或者空链表
        if (fast != slow || fast == null || fast.next == null) {
            return null;
        }

        // 寻找环的头结点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
