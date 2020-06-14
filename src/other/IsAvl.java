package other;

import structs.TreeNode;

/**
 * @author yd
 * @date 2020/3/14 22:27
 */
public class IsAvl {

    public boolean isBalanced(TreeNode root) {
        return isAvl(root) >= 0;
    }

    /**
     * 返回值大于等于0表示是树的高度， -1代表这棵树是非平衡树
     * @param root
     * @return
     */
    private int isAvl(TreeNode root) {
        int ans = 0;
        if (root != null) {
            if ((root.left != null && root.left.val > root.val) || (root.right != null && root.right.val < root.val)) {
                // 左右子节点不满足二叉排序树的性质
                return -1;
            }

            int leftHeight, rightHeight;
            if ((leftHeight = isAvl(root.left)) == -1 || (rightHeight = isAvl(root.right)) == -1) {
                // 左、右子树是非平衡树
                return -1;
            }

            if ((leftHeight - rightHeight > 1) || (rightHeight - leftHeight > 1)) {
                // 左右子树高度不满足性质
                return -1;
            }
            ans = Math.max(leftHeight, rightHeight) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(3);
        TreeNode node20 = new TreeNode(3);
        TreeNode node15 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
    }
}
