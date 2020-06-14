package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class num445 {


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 转换成string
        int len1 = 0, len2 = 0;
        StringBuilder str1Builder = new StringBuilder();
        StringBuilder str2Builder = new StringBuilder();
        ListNode p = l1;
        while (p != null) {
            str1Builder.append(p.val);
            p = p.next;
            len1++;
        }
        String str1 = str1Builder.toString();
        p = l2;
        while (p != null) {
            str2Builder.append(p.val);
            p = p.next;
            len2++;
        }
        String str2 = str2Builder.toString();

        ListNode ans = new ListNode(Integer.MAX_VALUE);
        int f = 0;
        int i = len1 - 1, j = len2 - 1;
        while (i >= 0 && j >= 0) {
            int num = (str1.charAt(i) - '0') + (str2.charAt(j) - '0') + f;
            ListNode node = new ListNode(num % 10);
            node.next = ans.next;
            ans.next = node;
            f = num / 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int num = (str1.charAt(i) - '0') + f;
            ListNode node = new ListNode(num % 10);
            node.next = ans.next;
            ans.next = node;
            f = num / 10;
            i--;
        }

        while (j >= 0) {
            int num = (str2.charAt(j) - '0') + f;
            ListNode node = new ListNode(num % 10);
            node.next = ans.next;
            ans.next = node;
            f = num / 10;
            j--;
        }

        if (f == 1) {
            ListNode node = new ListNode(1);
            node.next = ans.next;
            ans.next = node;
        }

        return ans.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 翻转链表
        l1 = revese(l1);
        l2 = revese(l2);

        int f = 0;
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ListNode p = l1, q = l2;
        while (p != null && q != null) {
            int num = p.val + q.val + f;
            ListNode node = new ListNode(num % 10);
            node.next = ans.next;
            ans.next = node;
            // 设置进位标志位
            f = num / 10;
            p = p.next;
            q = q.next;
        }

        while (p != null) {
            int num = p.val + f;
            ListNode node = new ListNode(num % 10);
            node.next = ans.next;
            ans.next = node;
            // 设置进位标志位
            f = num / 10;
            p = p.next;
        }

        while (q != null) {
            int num = q.val + f;
            ListNode node = new ListNode(num % 10);
            node.next = ans.next;
            ans.next = node;
            // 设置进位标志位
            f = num / 10;
            q = q.next;
        }

        if (f == 1) {
            ListNode node = new ListNode(f);
            node.next = ans.next;
            ans.next = node;
        }

        return ans.next;
    }

    /**
     * 翻转链表
     * @param l1
     * @return
     */
    public ListNode revese(ListNode l1) {
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        while (l1 != null) {
            // 取下一个节点
            ListNode p = l1;
            l1 = l1.next;
            // 头插法
            p.next = ans.next;
            ans.next = p;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append(1);
        builder.append(2);
        builder.append(3);
        builder.append(4);
        builder.append(5);
        System.out.println(builder.toString());
    }
}
