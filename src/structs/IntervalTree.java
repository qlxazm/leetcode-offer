package structs;

/**
 * 区间树
 */
public class IntervalTree {
    static class TreeNode {
        /**
         * 区间的左索引
         */
        public int l;
        /**
         * 区间的右边索引
         */
        public int h;
        /**
         * 区间的权重
         */
        public int w;

        public TreeNode(int l, int h, int w) {
            this.l = l;
            this.h = h;
            this.w = w;
        }
    }

    /**
     * 要建立区间树的数组
     */
    private int[] heights;
    /**
     * 区间树
     */
    private TreeNode[] tree;


    public IntervalTree(int[] heights) {
        this.heights = heights;
        tree = new TreeNode[4 * heights.length + 1];
    }

    /**
     * 建立区间树
     */
    public void buildTree() {
        buildTree(1, 0, heights.length - 1);
    }

    /**
     * 递归建立区间树
     * @param k k是在tree中的索引
     * @param i i是区间树中节点的左索引
     * @param j j是区间树中节点的右索引
     */
    private void buildTree(int k, int i, int j) {
        tree[k] = new TreeNode(i, j, heights[i]);
        if (i == j) { return ;}

        int middle = (i + j) >> 1;
        buildTree(k * 2, i, middle);
        buildTree(k * 2 + 1, middle + 1, j);

        tree[k].w = tree[k * 2].w + tree[k * 2 + 1].w;
    }

    /**
     * 区间树的区间查询
     * @param i
     * @param j
     * @return
     */
    public int searchInterVal(int i, int j) {
        return i < 0 || j >= heights.length ? -1 : searchInterVal(1, i, j);
    }

    /**
     * 区间树的区间查找
     * @param k
     * @param i
     * @param j
     * @return
     */
    private int searchInterVal(int k, int i, int j) {
        if (tree[k].l == i && tree[k].h == j) {return tree[k].w;}
        int middle = (tree[k].l + tree[k].h) >> 1;
        if (j <= middle) {
            // 左子树中寻找
            return searchInterVal(k * 2, i, j);
        }else if (i > middle){
            // 右子树中寻找
            return searchInterVal(k * 2 + 1, i, j);
        }else {
            // 横跨左右子树
            return searchInterVal(k * 2, i, middle) + searchInterVal(k * 2 + 1, middle + 1, j);
        }
    }


    public TreeNode[] getTree() {
        return tree;
    }

    public static void main(String[] args) {
//        int[] heights = {1,1,1,1,1,1,1,1};
        int[] heights = {1,2,3,4};
        IntervalTree intervalTree = new IntervalTree(heights);
        intervalTree.buildTree();
        System.out.println(intervalTree.searchInterVal(0,1));
    }
}
