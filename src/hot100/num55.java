package hot100;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 实例化成图，用图的方法解决
 */
public class num55 {
    public boolean canJump(int[] nums){
        int len = nums.length;
        boolean[] flags = new boolean[len];
        if (len <= 1) {return len !=0 && nums[0] >= 0;}

        flags[len - 1] = true;
        for (int i = len - 2; i >= 0; i--){
            int currValue = nums[i];
            for (int j = i; j <= currValue + i && j < len; j++){
                if (flags[j]){
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[0];
    }


    /*public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[][] draw = new boolean[len][len];
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j <= nums[i] && j + i < len; j++) {
                draw[i][j + i] = true;
            }
        }
        reachable(draw, visited, 0);
        return visited[len - 1];
    }*/

    /**
     * 深度优先遍历
     * @param
     * @param
     */
    /*public void reachable(boolean[][] draw, boolean[] visited, int source) {
        visited[source] = true;
        for (int i = 0; i < visited.length; i++){
            if (visited[i] || !draw[source][i]) {continue;}
            reachable(draw, visited, i);
        }
    }*/



    public static void main(String[] args) {
        num55 a = new num55();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
//        int[] nums = {2,0,0};
        System.out.println(a.canJump(nums));
    }
}
