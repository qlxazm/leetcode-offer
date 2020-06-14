package hot100;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author qian
 * @date 2020/1/13 22:24
 */
public class num739 {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] map = new int[71];
        int[] ans = new int[len];

        // 初始化
        map[ T[len - 1] - 30 ] = len - 1;

        for (int i = len - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = T[i] - 29; j < 71; j++) {
                if (map[j] > 0) {min = Math.min(min, map[j]);}
            }
            ans[i] = min == Integer.MAX_VALUE ? 0 : min - i;
            map[T[i] - 30] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        num739 a = new num739();

        temperatures = a.dailyTemperatures(temperatures);

        for (int i = 0; i < temperatures.length; i++) {
            System.out.print(temperatures[i] + ",");
        }


    }
}
