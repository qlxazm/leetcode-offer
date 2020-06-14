package hot100;

import structs.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class num105 {

    private HashMap<Integer, Integer> mapper = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0, len = inorder.length; i < len; i++) {
            mapper.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {return null;}
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = mapper.get(preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + (i - inStart), inorder, inStart, i - 1);
        root.right = buildTree(preorder, preStart + (i - inStart) + 1, preEnd, inorder, i + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        num105 a = new num105();

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = a.buildTree(preorder, inorder);
        int b = 0;
    }
}
