package hot100;

import structs.TreeNode;

/**
 * @author qian
 * @date 2020/1/5 21:22
 */
public class num437 {

    private int count;

    private int target;

    public int pathSum(TreeNode root, int sum) {
        target = sum;
        preOrder(root, new int[0]);
        return count;
    }

    public void preOrder(TreeNode root, int[] tempSums) {
        if (root == null) {return ;}
        int[] results = new int[tempSums.length + 1];

        int i = 0;
        for (int sum : tempSums) {
            results[i] = sum + root.val;
            if (results[i] == target) {count++;}
            i++;
        }

        results[i] = root.val;
        if (results[i] == target) {count++;}

        preOrder(root.left, results);
        preOrder(root.right, results);

    }

    public static void main(String[] args) {
        TreeNode node_10 = new TreeNode(10);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node__3 = new TreeNode(-3);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_11 = new TreeNode(11);
        TreeNode node_3_2 = new TreeNode(3);
        TreeNode node__2 = new TreeNode(-2);
        TreeNode node_1 = new TreeNode(1);

        node_10.left = node_5;
        node_10.right = node__3;

        node_5.left = node_3;
        node_5.right = node_2;

        node_3.left = node_3_2;
        node_3.right = node_2;

        node_2.right = node_1;

        node__3.right = node_11;

        num437 a = new num437();

        System.out.println(a.pathSum(node_10, 8));
    }
}
