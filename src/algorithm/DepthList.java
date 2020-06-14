package algorithm;

import structs.ListNode;
import structs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 */
public class DepthList {
    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> ans = new ArrayList<>();

        // 树的层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = null;
        ListNode head, tail;
        head = tail = new ListNode(-1);

        TreeNode last = tree, curr = null;
        queue.offer(tree);
        while(!queue.isEmpty()) {
            treeNode = queue.poll();
            tail.next = new ListNode(treeNode.val);
            tail = tail.next;

            if (treeNode.left != null) {
                queue.offer(treeNode.left);
                curr = treeNode.left;
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
                curr = treeNode.right;
            }

            // 遍历完了一层
            if (treeNode == last) {
                last = curr;
                ans.add(head.next);
                head = tail = new ListNode(-1);
            }
        }
        
        int len = ans.size();
        ListNode[] lists = new ListNode[len];
        for (int i = 0; i < len; i++) {
            lists[i] = ans.get(i);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.right = treeNode7;
        treeNode4.left = treeNode8;

        DepthList depthList = new DepthList();
        depthList.listOfDepth(treeNode1);
    }
}
