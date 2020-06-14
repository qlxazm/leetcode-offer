package hot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class num121 {
    static class TreeNode {
        public int l;
        public int h;
        public int max;

        public TreeNode(int l, int h, int max) {
            this.l = l;
            this.h = h;
            this.max = max;
        }
    }
    private int[] prices;
    /**
     * 区间树
     */
    private TreeNode[] tree;

    /**
     * 建立区间树
     * @param treeIndex 区间树的索引
     * @param i
     * @param j
     */
    private void buildTree(int treeIndex, int i, int j) {
        tree[treeIndex] = new TreeNode(i, j, prices[i]);
        if (i == j) {return;}
        // 创建左右子树
        int middle = (j + i) >> 1;
        buildTree(2 * treeIndex, i, middle);
        buildTree(2 * treeIndex + 1, middle + 1, j);
        tree[treeIndex].max = Math.max(tree[2 * treeIndex].max, tree[2 * treeIndex + 1].max);
    }

    /**
     * 区间树查找
     * @param lower
     * @param height
     * @return
     */
    private int searchInterval(int lower, int height) {
        return lower > height ? 0 : searchInterval(1, lower, height);
    }

    /**
     * 区间树查找
     * @param treeIndex
     * @param lower
     * @param height
     * @return
     */
    private int searchInterval(int treeIndex, int lower, int height) {
        if (tree[treeIndex].l == lower && tree[treeIndex].h == height) {
            return tree[treeIndex].max;
        }
        int middle = (tree[treeIndex].l + tree[treeIndex].h) >> 1;
        if (height <= middle) {
            // 在左子树中查找
            return searchInterval(2 * treeIndex, lower, height);
        }else if (lower > middle) {
            // 在右子树中查找
            return searchInterval(2 * treeIndex + 1, lower, height);
        }else {
            int leftValue = searchInterval(2 * treeIndex, lower, middle);
            int rightValue = searchInterval(2 * treeIndex + 1, middle + 1, height);
            return Math.max(leftValue, rightValue);
        }
    }

    /*public int maxProfit(int[] prices) {
        if (prices.length < 2) {return 0;}
        this.prices = prices;
        tree = new TreeNode[4 * prices.length + 1];
        buildTree(1, 0, prices.length - 1);

        int max = 0;
        for (int i = 0, len = prices.length - 1; i < len; i++) {
            int temp = searchInterval(i + 1, len);
            if (temp - prices[i] < 0) {continue;}
            max = Math.max(max, temp - prices[i]);
        }

        return max;
    }*/

   /* public int maxProfit(int[] prices){
        int max = 0, i, len = prices.length;
        HashMap<String, Integer> mapper = new HashMap<>();
        String key, suffix = Integer.toString(len - 1);
        for (i = len - 1; i >= 0; i--) {
            key = Integer.toString(i) + suffix;
            max = Math.max(max, prices[i]);
            mapper.put(key, max);
        }

        for (i = max = 0; i < len - 1; i++) {
            key = Integer.toString(i + 1) + suffix;
            int value = mapper.get(key);
            if (value - prices[i] < 0) {continue;}
            max = Math.max(max, value - prices[i]);
        }

        return max;
    }*/

    public int maxProfit(int[] prices) {
        int i, len = prices.length, result = 0, maxValue;
        if (len < 2) {return 0;}

        maxValue = prices[len - 1];
        for (i = len - 2; i >= 0; i--){
            if (maxValue - prices[i] > 0) {
                result = Math.max(result, maxValue - prices[i]);
            }
            maxValue = Math.max(maxValue, prices[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        num121 a = new num121();
//        int[] nums = {7,1,5,3,6,4};
        int[] nums = {7,6,5,4,3,2,1};
//        int[] nums = {1};
        System.out.println(a.maxProfit(nums));
    }
}
