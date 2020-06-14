package hot100;

import structs.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * @author qian
 * @date 2020/1/6 17:39
 */
public class num538 {

//    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inOrder(root, 0);
        return root;
    }

    /*
    * 改良版的后序遍历
    * */
    public void inOrder(TreeNode node, int sum) {
        if (node != null) {
            inOrder(node.right, sum);
            sum += node.val;
            node.val = sum;
            inOrder(node.left, sum);
        }
    }

    public static void main(String[] args) {

    }
}
