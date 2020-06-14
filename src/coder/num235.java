package coder;

import java.util.ArrayList;
/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class num235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int result = -1;
        ArrayList<TreeNode> pathA = new ArrayList<>();
        ArrayList<TreeNode> pathB = new ArrayList<>();
        findPath(p, root, pathA);
        findPath(q, root, pathB);

        int len = Math.min(pathA.size(), pathB.size());
        for (int i = 0; i < len; i++) {
            if (pathA.get(i) != pathB.get(i)) {
                result = i - 1;
                break;
            }
        }
        if (result == -1) {
            result = len - 1;
        }

        return pathA.get(result);
    }

    private void findPath(TreeNode p, TreeNode root, ArrayList<TreeNode> list) {
        while (true) {
            list.add(root);
            if (root.val == p.val) {
                break;
            }else if (p.val < root.val) {
                root = root.left;
            }else {
                root = root.right;
            }
        }
    }
}
