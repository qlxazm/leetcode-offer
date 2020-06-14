package hot100;

/**
 * https://leetcode-cn.com/problems/gas-station/
 * @author qian
 * @date 2020/1/28 14:48
 */
public class num134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int remain = 0, start = 0;
        for (int i = 0, L = gas.length; i < L; i = (i + 1) % L) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                // 所有的已经尝试完毕，应该结束啦
                remain = 0;
                if (i + 1 <= start) {break;}
                start = i + 1;
            } else if ((i + 1) % L == start) {
                return start;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        /*int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};*/

       /* int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};*/

        int[] gas = {3, 3, 4};
        int[] cost = {3, 4, 4};

        num134 a = new num134();
        System.out.print(a.canCompleteCircuit(gas, cost));
    }
}
