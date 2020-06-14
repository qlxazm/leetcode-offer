package hot100;

import structs.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class num23 {
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<ListNode> queue = new LinkedList<>();
        int len = lists.length;

        // 添加头节点并进入队列
        for (int i = 0; i < len; i++){
            /*ListNode head = new ListNode(Integer.MIN_VALUE);
            head.next = lists[i];*/
            queue.addLast(lists[i]);
        }

        while (queue.size() > 1) {
            ListNode a = queue.pollFirst();
            ListNode b = queue.pollFirst();
            queue.addLast(merge2List(a, b));
        }

        return queue.pollFirst();
    }

    public ListNode merge2List(ListNode a, ListNode b) {
        ListNode resultHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = resultHead, temp;

        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                a = a.next;
            }else {
                p.next = b;
                b = b.next;
            }
            p = p.next;
        }

        if (a == null) {
            p.next = b;
        }
        if (b == null) {
            p.next = a;
        }
        return resultHead.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(1);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);
        b1.next = b3;
        b3.next = b4;

        ListNode c2 = new ListNode(2);
        ListNode c6 = new ListNode(6);
        c2.next = c6;

        ListNode[] lists = {a1, b1, c2};

        num23 a = new num23();
        ListNode result = a.mergeKLists(lists);


        while (result != null) {
            System.out.print(result.val + ",");
            result = result.next;
        }
    }
}
