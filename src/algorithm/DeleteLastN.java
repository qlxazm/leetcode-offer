package algorithm;

/**
 */
public class DeleteLastN {

    static class ListNode{
        int val;
        ListNode next;
    }

    public static ListNode deleteLastN(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;

        ListNode fast = head, slow = head;

        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }

        // n有效
        if (n == 0) {
            ListNode p = root;
            while (fast != null) {
                p = slow;
                slow = slow.next;
                fast = fast.next;
            }
            p.next = slow.next;
            slow.next = null;
        }

        return root.next;
    }
}
