package hot100;

import structs.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 */
public class num337 {

    private Map<TreeNode, Integer> unVisited = new HashMap<>();
    private Map<TreeNode, Integer> visited = new HashMap<>();

    public int rob(TreeNode root) {
        postOrder(root);
        return root == null ? 0 : Math.max(unVisited.get(root), visited.get(root));
    }

    private void postOrder(TreeNode root) {
        // 如果是叶子节点
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);

        int leftMoney = 0, rightMoney = 0;
        // 如果不访问当前节点
        if (root.left != null) {
            leftMoney = Math.max(unVisited.get(root.left), visited.get(root.left));
        }
        if (root.right != null) {
            rightMoney = Math.max(unVisited.get(root.right), visited.get(root.right));
        }
        unVisited.put(root, leftMoney + rightMoney);

        // 如果访问当前节点
        leftMoney = rightMoney = 0;
        if (root.left != null) {
            leftMoney = unVisited.get(root.left);
        }
        if (root.right != null) {
            rightMoney = unVisited.get(root.right);
        }
        visited.put(root, leftMoney + rightMoney + root.val);

    }




    // 这种递归方法效率低
   /* private int max = 0;
    public int rob(TreeNode root) {
        rob(root, 0, false);
        return max;
    }*/

    /**
     * @param root          根节点
     * @param money         当前的钱数
     * @param lastIsRobed   父节点是否被盗
     * @return
     */
   /* private int rob(TreeNode root, int money, boolean lastIsRobed) {
        int leftMoney = 0, rightMoney = 0, left1 = 0, right1 = 0;
        if (root != null) {
            // 父节点已经被访问，当前节点就不能被访问
            leftMoney = rob(root.left, money, false);
            rightMoney = rob(root.right, leftMoney, false);
            if (!lastIsRobed){
                // 父节点没有被访问，可以访问当前节点，也可以不访问
                left1 = rob(root.left, money + root.val, true);
                right1 = rob(root.right, left1, true);
            }
            money = Math.max(right1, rightMoney);
        }
        max = Math.max(max, money);
        return money;
    }*/


    public static void main(String[] args) {
        num337 a = new num337();

        TreeNode node3_1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node3_3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);

        node3_1.left = node2;
        node3_1.right = node3_2;
        node2.right = node3_3;
        node3_2.right = node1;

       /* TreeNode node3_1 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node1_2 = new TreeNode(1);

        node3_1.left = node4;
        node3_1.right = node5;
        node4.left = node1_1;
        node4.right = node3_2;
        node5.right = node1_2;*/

        System.out.print(a.rob(node3_1));
    }
}
