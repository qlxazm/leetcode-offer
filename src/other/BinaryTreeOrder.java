package other;

import structs.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的3种非递归遍历
 * @author yd
 * @date 2020/3/11 19:10
 */
public class BinaryTreeOrder {

    public void preOrder(TreeNode root) {
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            do{
                while (p != null) {
                    System.out.println(p.val);
                    stack.addFirst(p);
                    p = p.left;
                }
                p = stack.pollFirst().right;
            }while (!stack.isEmpty() || p != null);
        }
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode p = root;
            do{
                while (p != null) {
                    stack.addFirst(p);
                    p = p.left;
                }
                p = stack.pollFirst();
                System.out.println(p.val);
                p = p.right;
            }while (!stack.isEmpty() || p != null);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            LinkedList<Pair> stack = new LinkedList<>();
            Pair top = null;
            TreeNode p = root;
            do{
                while (p != null) {
                    stack.addFirst(new Pair(p, false));
                    p = p.left;
                }
                top = stack.peekFirst();
                if (!top.getRight()) {
                    top.setRight(true);
                    p = top.getNode().right;
                } else {
                    stack.pollFirst();
                    System.out.println(top.getNode().val);
                }
            }while (!stack.isEmpty() || p != null);
        }
    }

    public void postOrder1(TreeNode root) {
        if (root != null) {
            LinkedList<Pair> stack = new LinkedList<>();
            TreeNode p = root;
            Pair top = null;
            do {
                while (p != null) {
                    stack.addFirst(new Pair(p, false));
                    p = p.left;
                }
                top = stack.peekFirst();
                // 从左边返回的
                if (!top.getRight()) {
                    top.setRight(true);
                    p = top.getNode().right;
                } else {
                    stack.pollFirst();
                    System.out.println(top.getNode().val);
                }

            } while(!stack.isEmpty() || p != null);
        }
    }

    class Pair{
        TreeNode node;
        Boolean isRight;

        public Pair(TreeNode node, Boolean isRight) {
            this.node = node;
            this.isRight = isRight;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public Boolean getRight() {
            return isRight;
        }

        public void setRight(Boolean right) {
            isRight = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;

        node20.left = node15;
        node20.right = node7;

        BinaryTreeOrder a = new BinaryTreeOrder();
//        a.preOrder(node3);
//        a.inOrder(node3);
        a.postOrder(node3);

    }
}
