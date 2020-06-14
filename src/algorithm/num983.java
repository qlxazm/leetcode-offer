package algorithm;

/**
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 * 记忆化搜索
 */
public class num983 {

    int[] len = {1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        int[] buffer = new int[days.length];
        return dfs(days, costs, 0, buffer);
    }

    public int dfs(int[] days, int[] costs, int start, int[] buffer) {

        if (start >= days.length) {
            return 0;
        }

        if (buffer[start] != 0) {return buffer[start];}

        int j = start, ans = Integer.MAX_VALUE, tmp = 0;
        for (int i = 0; i < costs.length; i++) {
            tmp = costs[i];
            while (j < days.length && days[j] < days[start] + len[i]) { j++; }
            tmp += dfs(days, costs, j, buffer);
            ans = Math.min(ans, tmp);
        }

        buffer[start] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {7, 2,15};
        num983 num983 = new num983();
        System.out.println(num983.mincostTickets(days, costs));
    }
}
