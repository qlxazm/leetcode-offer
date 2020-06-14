package algorithm;

import structs.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class num23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headr = new ListNode(Integer.MAX_VALUE), tail = headr;
        int len = lists.length;
        PriorityQueue<ListNode> minStack = new PriorityQueue<>((o1, o2) -> { return o1.val - o2.val;});
        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                minStack.offer(lists[i]);
            }
        }

        while (!minStack.isEmpty()) {
            ListNode node = minStack.poll();
            if (node.next != null) {
                minStack.offer(node.next);
            }
            tail.next = node;
            node.next = null;
            tail = node;
        }
        return headr.next;
    }

    public static void main(String[] args) {
        // 小顶堆
        PriorityQueue<Integer> minStack = new PriorityQueue<>((o1, o2) -> { return o1 - o2;});
        // 大顶堆
        PriorityQueue<Integer> maxStack = new PriorityQueue<>((o1, o2) -> { return o2 - o1;});

        minStack.add(2);
        maxStack.add(2);

        minStack.add(5);
        maxStack.add(5);

        minStack.add(1);
        maxStack.add(1);

        minStack.add(3);
        maxStack.add(3);

        minStack.add(1);
        maxStack.add(1);

        minStack.add(4);
        maxStack.add(4);

        while (!minStack.isEmpty()) {
            System.out.print(minStack.poll() + ",");
        }
        System.out.println("");

        while (!maxStack.isEmpty()) {
            System.out.print(maxStack.poll() + ",");
        }
    }
}
