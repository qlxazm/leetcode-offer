package hot100;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class num236 {

    private TreeNode firstAncestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inOrder(root, p , q);
        return firstAncestor;
    }
    private boolean inOrder(TreeNode root, TreeNode p, TreeNode q) {
        boolean left = false, right = false, self;
        if (root.left != null) { left = inOrder(root.left, p, q); }
        self = root.val == p.val || root.val == q.val;
        if (root.right != null) { right = inOrder(root.right, p, q);}

        // 左中右如果出现两个true，就表示已经访问到拉
        if ((left && right) || (left && self) || (right && self)) {
            firstAncestor = root;
        }
        return left || self || right;
    }

   /*
   方法1：使用二叉树的分递归后序遍历，时间复杂度比较高
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> stack1 = postOrder(root, p);
        List<TreeNode> stack2 = postOrder(root, q);
        TreeNode last = stack1.get(0);
        for(int i = 0, len = Math.min(stack1.size(), stack2.size()); i < len; i++) {
            if (stack1.get(i).val != stack2.get(i).val) {break;}
            last = stack1.get(i);
        }
        return last;
    }

    private List<TreeNode> postOrder(TreeNode root, TreeNode target) {
        List<TreeNode> buffer = new ArrayList<>();
        // 标志位栈，如果是false代表节点的右子树没有访问，否则，表示右子树已经访问过啦
        List<Boolean> tags = new ArrayList<>();

        TreeNode router = root;
        while (buffer.size() > 0 || router != null) {
            while (router != null) {
                buffer.add(router);
                tags.add(false);
                router = router.left;
            }
            if (!tags.get(tags.size() - 1)){
                router = buffer.get(buffer.size() - 1).right;
                tags.set(tags.size() - 1, true);
            }else {
                if (buffer.get(buffer.size() - 1).val == target.val) {return buffer;}
                TreeNode top = buffer.remove(buffer.size() - 1);
                tags.remove(tags.size() - 1);
            }
        }
        return buffer;
    }
*/
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        num236 a = new num236();

        System.out.print(a.lowestCommonAncestor(node3, node1, node5).val);
    }
}
