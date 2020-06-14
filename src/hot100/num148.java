package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 */
public class num148 {
    private ListNode sort(ListNode head) {
        ListNode left, leftNail, right, rightNail, axis = head, p;
        if (head.next == null) {
            head.next = head;
            return head;
        }

        // 快速排序，左右切分
        p = axis.next;
        axis.next = left = leftNail = rightNail = right = null;
        while (p != null) {
            if (p.val < axis.val) {
                if (left == null) {
                    left = p;
                }else {
                    leftNail.next = p;
                }
                leftNail = p;
                p = p.next;
                leftNail.next = null;
            }else {
                if (right == null) {
                    right = p;
                }else {
                    rightNail.next = p;
                }
                rightNail = p;
                p = p.next;
                rightNail.next = null;
            }
        }
        // 递归排序左右子树
        if (right != null) {
            ListNode temp = sort(right);
            axis.next = temp.next;
            temp.next = null;
        }
        if (left != null) {
            ListNode temp = sort(left);
            left = temp.next;
            temp.next = axis;
        }else {
            left = axis;
        }

        // 约定返回尾指针，尾指针指向头节点，形成循环链表
        if (right != null) {
            rightNail.next = left;
            return rightNail;
        }else {
            axis.next = left;
            return axis;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head != null) {
            ListNode nail = sort(head);
            head = nail.next;
            nail.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        num148 a = new num148();

       /* ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);

        node4.next = node2;
        node2.next = node1;
        node1.next = node3;*/

        ListNode node4 = new ListNode(-1);
        ListNode node2 = new ListNode(0);
        ListNode node1 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        node3.next = node5;

       /* while (node4 != null) {
            System.out.print(node4.val + ", ");
            node4 = node4.next;
        }
        System.out.println("\n");*/

        node4 = a.sortList(node4);
        while (node4 != null) {
            System.out.print(node4.val + ", ");
            node4 = node4.next;
        }
    }
}
