package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class num234 {
    public boolean isPalindrome(ListNode head) {
        // 统计长度
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count++;
            p = p.next;
        }

        int k = count / 2;
        ListNode root = new ListNode(Integer.MAX_VALUE), q;
        p = head;
        // 头插法
        while(k > 0) {
            q = p;
            p = p.next;
            q.next = root.next;
            root.next = q;
            k--;
        }
        if((count & 1) == 1) { p = p.next; }

        q = root.next;
        while(p != null) {
            if(p.val != q.val) {return false;}
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
