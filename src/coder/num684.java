package coder;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 * 寻找图上的环
 * 无向图：并查集
 * 有向图：使用拓扑排序（）
 */
public class num684 {
    public int[] findRedundantConnection(int[][] edges) {
        int MAX_NODES = 1001;

        int[] matrix = new int[MAX_NODES];
        int[] edge = null;
        int rootA, rootB;
        for (int i = 0, len = edges.length; i < len; i++) {
            edge = edges[i];
            rootA = find(matrix, edge[1]);
            rootB = find(matrix, edge[0]);
            if (rootA == rootB) {
                break;
            }else {
                join(matrix, rootA, rootB);
            }
        }
        return edge;
    }

    private int find(int[] matrix, int node) {
        if (node > matrix.length){
            return 0;
        }
        while(matrix[node] != 0) {
            node = matrix[node];
        }
        return node;
    }

    private int join(int[] matrix,int rootA, int rootB) {
        matrix[rootA] = rootB;
        return rootB;
    }

    public static void main(String[] args) {
        int[][] edges = {
               /* {1,2},
                {2,3},
                {3,4},
                {1,4},
                {1,5},*/

                /*{1,2},
                {1,3},
                {2,3}*/

                {1,4},
                {3,4},
                {1,3},
                {1,2},
                {4,5}

                /*{16,25},{7,9},{3,24},
                {10,20},{15,24},{2,8},
                {19,21},{2,15},{13,20},
                {5,21},{7,11},{6,23},
                {7,16},{1,8},{17,20},
                {4,19},{11,22},{5,11},
                {1,16},{14,20},{1,4},
                {22,23},{12,20},{15,18},
                {12,16}*/

                /*                            16 -- 25
                                              7  -- 9
                                              3  -- 24 --
                                              10 -- 20

                *
                *
                *
                * */

        };
        int[] edge = new num684().findRedundantConnection(edges);
        System.out.println("[" + edge[0] + ", " + edge[1] + "]");
    }
}
