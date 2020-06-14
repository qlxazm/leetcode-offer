package algorithm;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/submissions/
 */
public class num148 {

    public ListNode sortList(ListNode head) {
        if (head != null && head.next != null) {
            // 切分成两个数组
            ListNode mid = partition(head);
            ListNode p = mid.next;
            mid.next = null;
            // 排序子链表
            head = sortList(head);
            p = sortList(p);
            // 合并两个子链表
            head = merge(head, p);
        }
        return head;
    }

    /**
     * 切分链表
     * @param node
     * @return
     */
    private ListNode partition(ListNode node) {

        // 特殊处理两个节点的情况
        if (node != null && node.next != null && node.next.next == null) {
            return node;
        }

        ListNode fast, slow;
        fast = slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode ans = new ListNode(Integer.MAX_VALUE);
        ListNode p = null, tail = ans;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p = h1;
                h1 = h1.next;
            } else {
                p = h2;
                h2 = h2.next;
            }
            tail.next = p;
            tail = p;
        }

        if (h1 != null) {
            tail.next = h1;
        }
        if (h2 != null) {
            tail.next = h2;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);

        node4.next = node2;
        node2.next = node1;
        node1.next = node3;

        num148 num148 = new num148();
        ListNode p = num148.sortList(node4);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
