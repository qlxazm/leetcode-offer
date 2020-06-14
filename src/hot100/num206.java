package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class num206 {
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        // 采用头插法
        ListNode temp = null;
        while (head != null) {
            temp = result.next;
            result.next = head;
            head = head.next;
            result.next.next = temp;
        }
        return result.next;
    }

    public static void main(String[] args) {

    }
}
