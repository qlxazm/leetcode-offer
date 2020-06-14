package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class num234 {
    public boolean isPalindrome(ListNode head) {
        // 第一遍统计链表长度
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        // 采用尾插法，拿出前一半节点
        int i = 0, half = count / 2;
        ListNode halfHead = new ListNode(Integer.MAX_VALUE);
        p = head;
        while (i < half) {
            ListNode nextList = halfHead.next;
            halfHead.next = p;
            p = p.next;
            halfHead.next.next = nextList;
            i++;
        }

        if ((count & 1) == 1){
            p = p.next;
        }
        halfHead = halfHead.next;

        while (p != null && halfHead != null) {
            if (p.val != halfHead.val) {return false;}
            p = p.next;
            halfHead = halfHead.next;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
