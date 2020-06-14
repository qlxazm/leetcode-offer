package hot100;

import structs.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 1、首先尝试，使用 先序序列 + 中序序列 实现编码和解码，但是使用这种方法就要求每个节点的值存储的都不一样。
 * 但是，这个题目的节点值有可能重复
 * 2、使用层次遍历。在编码阶段要树看成完全二叉树，对于null的位置要补充null值，这样在解码的时候才能正确解码。但是，
 * 随之而来的问题是，在解码阶段需要操作大量的null值（因为编码阶段可能编码进很多null值），所以出现超时。
 * 3、使用深度优先遍历（这里是先序遍历）
 */
public class num297 {
    static class Codec {

        public String serialize(TreeNode root) {
           return rserialize(root, "");
        }

        private String rserialize(TreeNode root, String s) {
            if (root == null) {
                s += "null,";
                return s;
            }
            s += root.val + ",";
            s = rserialize(root.left, s);
            s = rserialize(root.right, s);
            return s;
        }

        public TreeNode deserialize(String data) {
            List<String> values = new LinkedList<String>(Arrays.asList(data.split(",")));
            return rdeserialize(values);
        }

        private TreeNode rdeserialize(List<String> values) {
            if (values.get(0).equals("null")) {
                values.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(values.get(0)));
            values.remove(0);
            root.left = rdeserialize(values);
            root.right = rdeserialize(values);
            return root;
        }

        /**
         * 使用树的层次遍历：超时
         */
        /*private static final String SEPARATOR = ",";
        private static final String NULL_STR = "null";
        public String serialize(TreeNode root) {
            String result = "[";
            if (root != null) {
                int len = getNodeTotals(root), i = 0;
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.offer(root);
                while (i < len) {
                    root = queue.poll();
                    if (root == null) {
                        result += NULL_STR + SEPARATOR;
                        queue.offer(null);
                        queue.offer(null);
                    }else {
                        result += root.val + SEPARATOR;
                        queue.offer(root.left);
                        queue.offer(root.right);
                        i++;
                    }
                }
                result = result.substring(0, result.length() - 1);
            }
            return result + "]";
        }

        private int getNodeTotals(TreeNode root) {
            int leftCount = root.left != null ? getNodeTotals(root.left) : 0;
            int rightCount = root.right != null ? getNodeTotals(root.right) : 0;
            return leftCount + rightCount + 1;
        }

        public TreeNode deserialize(String data) {
            if (data.length() == 2) {return null;}

            data = data.substring(1, data.length() - 1);
            String[] values = data.split(SEPARATOR);

            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(values[0])), p = null;
            queue.offer(root);
            int i = 1, len = values.length;
            while (i < len) {
                p = queue.poll();
                if (p == null) {
                    queue.offer(null);
                    queue.offer(null);
                    i += 2;
                    continue;
                }
                // 建立左子树
                if (!values[i].equals(NULL_STR)) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    p.left = left;
                    queue.offer(left);
                }else {
                    queue.offer(null);
                }
                i++;
                // 建立右子树
                if (i < len && !values[i].equals(NULL_STR)) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    p.right = right;
                    queue.offer(right);
                }else {
                    queue.offer(null);
                }
                i++;
            }

            return root;
        }*/
    }

    public static void main(String[] args) {
        num297.Codec a = new num297.Codec();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
//        node4.left = node6;

        String serial = a.serialize(node1);
        System.out.print(serial);

        TreeNode root = a.deserialize(serial);
        int b = 11;

      /* String serial = "[1,2,3,null,null,4,5,null,null,null,null,6]";
       */
    }
}
