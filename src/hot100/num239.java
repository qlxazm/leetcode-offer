package hot100;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class num239 {
    /**
     * 线段树节点
     */
    static class Node {
        public int l;
        public int h;
        public int w;

        public Node(int l, int h, int w) {
            this.l = l;
            this.h = h;
            this.w = w;
        }
    }

    private Node[] segmentTree;

    private void buildTree(int[] nums) {
        buildTree(nums, 1, 0, nums.length - 1);
    }

    /**
     * 建立线段树
     * @param nums
     * @param k
     * @param l
     * @param h
     */
    private void buildTree(int[] nums, int k, int l, int h){
        segmentTree[k] = new Node(l, h, nums[l]);
        if (l == h) {return;}
        int middle = (h + l) >> 1;
        buildTree(nums, 2 * k, l, middle);
        buildTree(nums, 2 * k + 1, middle + 1, h);
        segmentTree[k].w = Math.max(segmentTree[2 * k].w, segmentTree[2 * k + 1].w);
    }

    /**
     * 查找线段树
     * @param k
     * @param l
     * @param h
     * @return
     */
    private int search(int k, int l, int h) {
        if (segmentTree[k].l == l && segmentTree[k].h == h) {return segmentTree[k].w;}
        int middle = (segmentTree[k].l + segmentTree[k].h) >> 1;
        if (h <= middle){
            // 左子树中查找
            return search(2 * k, l, h);
        }else if (middle < l){
            // 右子树中查找
            return search(2 * k + 1, l, h);
        }else {
            return Math.max(search(2 * k, l, middle), search(2 * k + 1, middle + 1, h));
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        if (len == 0) {return result;}
        // 建立线段树
        segmentTree = new Node[4 * len + 1];
        buildTree(nums);

        for (int i = 0, j = k - 1, m = 0; j < len; i++, j++, m++) {
            result[m] = search(1, i, j);
        }
        return result;
    }

    /**
     * 建立大顶堆
     * @param maxHeap
     */
    private void buildMaxHeap(int[] maxHeap) {
        // 从上到下调整来建立大顶堆
        for (int i = maxHeap.length / 2; i > 0; i--){
            adjustDown(maxHeap, i);
        }
    }

    private void adjustDown(int[] maxHeap, int k) {
        maxHeap[0] = maxHeap[k];
        for (int i = 2 * k, len = maxHeap.length; i <= len; i *= 2) {
            // 找左右子树中比较大的那一个
            if (maxHeap[i] < maxHeap[i + 1]) {i++;}
            // 如果比左右子树中最大的小，就需要调整
            if (maxHeap[0] < maxHeap[i]) {
                maxHeap[k] = maxHeap[i];
                k = i;
            }else {
                break;
            }
        }
        maxHeap[k] = maxHeap[0];
    }

    public static void main(String[] args) {
        num239 a = new num239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        nums = a.maxSlidingWindow(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}
