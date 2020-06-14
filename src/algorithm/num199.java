package algorithm;

import structs.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class num199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(map, root, 1);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    /**
     * 深度优先遍历，每一层把第一个访问到的节点标记上
     * @param map
     * @param root
     * @param depth
     */
    public void dfs(HashMap<Integer, Integer> map, TreeNode root, int depth) {
        if (root != null) {
            map.put(depth, map.getOrDefault(depth, root.val));
            dfs(map, root.right, depth + 1);
            dfs(map, root.left, depth + 1);
        }
    }
}
