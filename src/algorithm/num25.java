package algorithm;

import structs.ListNode;

import java.util.HashSet;

/**
 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class num25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        // 统计长度
        ListNode p = head, q = null, last = null;
        while (p != null) {
            count++;
            p = p.next;
        }

        ListNode ans = new ListNode(1);
        ans.next = head;
        p = ans;
        while (count >= k) {
            int i = k;
            q = p;
            while (i > 0) {
                p = p.next;
                i--;
            }

            last = p.next;
            ListNode[] headTail = reveseList(q.next, last);
            q.next = headTail[0];
            headTail[1].next = last;
            p = headTail[1];

            count -= k;
        }

        return ans.next;
    }

    /**
     * 翻转单链表
     * @param root
     * @return
     */
    public ListNode[] reveseList(ListNode root, ListNode last) {
        ListNode head = new ListNode(1), p = root, q, tail = null;
        while (p != last) {
            q = p;
            p = p.next;
            q.next = head.next;
            // 记录尾节点
            if (head.next == null) {
                tail = q;
            }
            head.next = q;
        }
        return new ListNode[]{head.next, tail};
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        num25 num25 = new num25();

        ListNode p = num25.reverseKGroup(node1, 2);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

}
