package hot100;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class num101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {return true;}
        Stack<TreeNode> stack = new Stack<>(), rightStack = new Stack<>();
        TreeNode p = root.left, q = root.right;
        while ((!stack.empty() || p != null) || (!rightStack.empty() || q != null)) {
            while (p != null && q != null) {
                stack.push(p);
                p = p.left;
                rightStack.push(q);
                q = q.right;
            }

            // 如果只有一个为空，就返回
            if ((p == null && q != null) || (p != null && q == null)) {return false;}

            p = stack.pop();
            q = rightStack.pop();
            if (p.val != q.val) {return false;}

            p = p.right;
            q = q.left;
        }

        return true;

      /*  for (int i = 0, len = results.size(); i < len; i++) {
            System.out.println(results.get(i) == null ? "null" : results.get(i) + ", ");
        }*/

        /*int j = results.size(), i = 0;
        if (j > 0 && (j & 1) == 0) {return false;}
        j--;
        while (i <= j) {
            boolean isValid = results.get(i) == null && results.get(j) == null;
            isValid = isValid || (results.get(i) != null && results.get(j) != null && results.get(i).equals(results.get(j)));
            if (!isValid) {return false;}
            i++;
            j--;
        }*/
    }

    public static void main(String[] args) {
        num101 a = new num101();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
         node1.left = node2;
        node1.right = node3;


     /* TreeNode node1 = new TreeNode(1);
      TreeNode node2_1 = new TreeNode(2);
      TreeNode node2_2 = new TreeNode(2);
      TreeNode node2_4 = new TreeNode(2);
      TreeNode node2_6 = new TreeNode(2);

      node1.left = node2_1;
      node1.right = node2_2;

      node2_1.left = node2_4;

      node2_2.left = node2_6;*/

        /*TreeNode node1 = new TreeNode(1);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node2_3 = new TreeNode(2);
        TreeNode node3_5 = new TreeNode(3);
        TreeNode node3_6 = new TreeNode(3);

        node1.left = node2_2;
        node1.right = node2_3;

        node2_2.right = node3_5;
        node2_3.left = node3_6;
*/


       System.out.println(a.isSymmetric(node1));
    }
}
