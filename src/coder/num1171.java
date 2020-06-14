package coder;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class num1171 {
    private static class  ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        /*int MAX_NODE_NUM = 1000, listSize = 0;
        int[] nums = new int[MAX_NODE_NUM + 1];
        int[] index = new int[MAX_NODE_NUM + 1];
        int[][] matrix = new int[MAX_NODE_NUM + 1][MAX_NODE_NUM + 1];

        while (head.next != null) {
            listSize++;
            nums[listSize] = matrix[listSize][listSize] = head.next.val;
            head.next = head.next.next;
        }
        int i = 1, j;
        for (; i <= listSize; i++){
            for (j = i + 1; j <= listSize; j++) {
                matrix[i][j] = matrix[i][j - 1] + nums[j];
            }
        }

        return null;*/

        int MAX_NODE_NUM = 1000;
        int[] prefixSums = new int[MAX_NODE_NUM + 1];
        boolean[] removeFlags = new boolean[MAX_NODE_NUM + 1];
        Map<Integer, Integer>  map = new HashMap<>();
        int i, j;
        Integer prefixSum;
        ListNode p = head.next;

//        map.put(0, 0);
        for (i = 1; p != null; p = p.next) {
            prefixSums[i] = prefixSums[i - 1] + p.val;

            // 查找前缀和中相同的值
            prefixSum = map.get(prefixSums[i]);
            if (prefixSum != null) {
                for (j = prefixSum + 1; j <= i; j++) {
                    removeFlags[j] = true;  // 标记可以删除的节点
                }
                map.remove(prefixSums[i]);
            }else {
                map.put(prefixSums[i], i);
            }
            i++;
        }

        // 移除被标记为可以删除的节点
        p = head;
        j = 1;
        while (p.next != null) {
            if (removeFlags[j++]) {
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode header = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(-3);
        ListNode node5 = new ListNode(4);

        node5.next = null;
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        header.next = node1;

        ListNode head = new num1171().removeZeroSumSublists(header);

        while (head.next != null) {
            System.out.println(head.next.val);
            head = head.next;
        }

    }

}
