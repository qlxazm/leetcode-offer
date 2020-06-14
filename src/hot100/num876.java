package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class num876 {

    public ListNode middleNode(ListNode head) {
        ListNode ans = head;
        int len = 0;
        while (head.next != null) {
            ans = ans.next;
            len++;
        }
        if ((len & 1) == 1) {
            len = len / 2 + 1;
        } else {
            len = len / 2;
        }
        ans = head;
        while (len > 0) {
            ans = ans.next;
            len--;
        }
        return ans;
    }

}
