package hot100;

import structs.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class num124 {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       pathSum(root);
       return maxSum;
    }

    private int pathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }
        int leftValue = 0, rightValue = 0, temp = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        if (root.left != null) {
            leftValue = pathSum(root.left);
            temp = getMaxValue(root.val, root.val + leftValue, leftValue);
            ans = getMaxValue(root.val, root.val + leftValue);
        }
        if (root.right != null) {
            rightValue = pathSum(root.right);
            temp = getMaxValue(root.val, root.val + rightValue, rightValue, temp);
            ans = getMaxValue(root.val, root.val + rightValue, ans);
        }

        if (root.left != null && root.right != null) {
            temp = getMaxValue(temp, root.val + leftValue + rightValue);
//            ans = getMaxValue(ans, root.val + leftValue + rightValue);
        }
        maxSum = Math.max(maxSum, temp);
        return ans;
    }

    private int getMaxValue(int ...args) {
        int max = Integer.MIN_VALUE;
        for (int i = 0, len = args.length; i < len; i++) {
            max = Math.max(max, args[i]);
        }
        return max;
    }


    private int ans = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        maxPath(root);
        return ans;
    }

    private Integer maxPath(TreeNode root) {
        if (root != null) {
            Integer leftMaxSum = maxPath(root.left);
            Integer rightMaxSum = maxPath(root.right);

            int temp = root.val;
            if (leftMaxSum != null) {
                temp = Math.max(temp, leftMaxSum + root.val);
            }
            if (rightMaxSum != null) {
                temp = Math.max(temp, rightMaxSum + root.val);
            }

            /**
             * 寻找
             * leftMaxSum + root.val + rightMaxSum,
             * leftMaxSum + root.val,
             * rightMaxSum + root.val,
             * root.val,
             * leftMaxSum,
             * rightMaxSum
             * 的最大者作为临时答案
             */
            ans = Math.max(temp, ans);
            if (leftMaxSum != null) {
                ans = Math.max(ans, leftMaxSum);
            }
            if (rightMaxSum != null) {
                ans = Math.max(ans, rightMaxSum);
            }
            if (leftMaxSum != null && rightMaxSum != null) {
                ans = Math.max(ans, leftMaxSum + root.val + rightMaxSum);
            }

            /**
             * 寻找
             * leftMaxSum + root.val,
             * rightMaxSum + root.val,
             * root.val
             */
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        num124 a = new num124();

        /*TreeNode node_10 = new TreeNode(-10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node_10.left = node9;
        node_10.right = node20;
        node20.left = node15;
        node20.right = node7;

        System.out.println(a.maxPathSum(node_10));*/

       /* TreeNode node_2 = new TreeNode(-2);
        TreeNode node_1 = new TreeNode(-1);
        node_2.left = node_1;
        System.out.println(a.maxPathSum(node_2));
        */

       TreeNode node5 = new TreeNode(5);
       TreeNode node4_1 = new TreeNode(4);
       TreeNode node8 = new TreeNode(8);
       TreeNode node11 = new TreeNode(11);
       TreeNode node13 = new TreeNode(13);
       TreeNode node4_2 = new TreeNode(4);
       TreeNode node7 = new TreeNode(7);
       TreeNode node2 = new TreeNode(2);
       TreeNode node1 = new TreeNode(1);

       node5.left = node4_1;
       node5.right = node8;

       node4_1.left = node11;
       node11.left = node7;
       node11.right = node2;

       node8.left = node13;
       node8.right = node4_2;
       node4_2.right = node1;

       System.out.println(a.maxPathSum(node5));
    }
}
