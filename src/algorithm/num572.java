package algorithm;

import structs.TreeNode;

/**
 */
public class num572 {

    /**
     * 方法1，对于s中的每一个节点进行一次匹配
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSubtree(s, t, t);
    }

    private boolean isSubtree(TreeNode s, TreeNode t, TreeNode root) {
        if(s == t) { return true; }
        if(s == null || t == null) {return false;}
        // 以s为根节点的树与t是否相似
        if(isSame(s, t)) { return true; }
        // 否则判断s的左子树或者右子树与t是否相似
        return isSubtree(s.left, root, root) || isSubtree(s.right, root, root);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == t) { return true; }
        if(s == null || t == null) {return false;}
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }


}
