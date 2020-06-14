package hot100;

import structs.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class num142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        do {
            if (fast == null || fast.next == null) {return null;}
            fast = fast.next.next;
            slow = slow.next;
        }while (fast != slow);

        // 现在fast肯定指向了环中间的一个节点，现在计算这个环的长度
        int count = 0;
        do {
            fast = fast.next;
            count++;
        }while (fast != slow);

        // 快指针先走count步
        fast = slow = head;
        while (count > 0) { fast = fast.next; count--;}

        // 快慢指针同步走
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        num142 a = new num142();
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);

       /* node3.next = node2;
        node2.next = node0;
        node0.next = node_4;
        node_4.next = node2;*/

        ListNode node = a.detectCycle(node3);
        if (node == null) {
            System.out.println("没有环");
        }else {
            System.out.println("环是" + node + "，内容是：" + node.val);
        }
    }
}
