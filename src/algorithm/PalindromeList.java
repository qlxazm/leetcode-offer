package algorithm;

import structs.ListNode;

/**
 * 判断是否是回文串
 */
public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head, q;
        // 计算链表的长度
        while(p != null) {
            len++;
            p = p.next;
        }
        if(len < 2) {return true;}

        int k = 1;
        p = head;
        while(k < len / 2) {
            p = p.next;
            k++;
        }
        // 修正一下奇数的情况
        if((len & 1) == 1) {
            q = new ListNode(p.next.val);
            q.next = p.next;
            p.next = q;
            p = p.next;
        }

        q = p.next;
        p = head;
        // 翻转q
        q = reverseList(q);

        while(p != null && q != null) {
            if(p.val != q.val) {return false;}
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode ans = new ListNode(-1), p;
        while(head != null) {
            p = head;
            head = head.next;

            p.next = ans.next;
            ans.next = p;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(1);
        ListNode node0 = new ListNode(0);
        ListNode node1_2 = new ListNode(1);
        node1_1.next = node0;
        node0.next = node1_2;

        PalindromeList palindromeList = new PalindromeList();

        palindromeList.isPalindrome(node1_1);
    }
}
