package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class num160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aCount = 0, bCount = 0;
        ListNode p = headA, q = headB;
        // 计算A、B链表的长度
        while (p != null) {
            aCount++;
            p = p.next;
        }
        while (q != null) {
            bCount++;
            q = q.next;
        }

        // 长的一个链表先走
        p = headA;
        q = headB;
        int i = 0, diff = 0;
        if (aCount > bCount) {
            diff = aCount - bCount;
            while (p != null && i < diff) {
                p = p.next;
                i++;
            }
        }
        i = 0;
        if (aCount < bCount) {
            diff = bCount - aCount;
            while (q != null && i < diff) {
                q = q.next;
                i++;
            }
        }

        while (p != null && q != null) {
            if (p == q) {return p;}
            p = p.next;
            q = q.next;
        }

        return null;
    }

    public static void main(String[] args) {
//        8
//                [4,1,8,4,5]
//[5,0,1,8,4,5]
//        2
//        3

        ListNode node4 = new ListNode(4);

        ListNode node5 = new ListNode(5);
        ListNode node0 = new ListNode(0);

        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node4_1 = new ListNode(4);
        ListNode node5_1 = new ListNode(5);

        node4.next = node1;
        node1.next = node8;
        node8.next = node4_1;
        node4_1.next = node5_1;

        node5.next = node0;
        node0.next = node1;
        node1.next = node8;
        node8.next = node4_1;
        node4_1.next = node5_1;

        num160 a = new num160();
        System.out.print(a.getIntersectionNode(node4, node5).val);
    }
}
