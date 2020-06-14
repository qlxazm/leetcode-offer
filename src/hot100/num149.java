package hot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/max-points-on-a-line/
 * @author qian
 * @date 2020/2/4 10:35
 */
public class num149 {

    public int maxPoints(int[][] points) {
        int m = points.length, max = 0;
        HashMap<Float, Integer> buffer = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                float key = (float) (points[i][1] - points[j][1]) / (float) (points[i][0] - points[j][0]);
                int value = buffer.containsKey(key) ? buffer.get(key) + 1 : 1;
                buffer.put(key, value);
                max = Math.max(max, value);
            }
        }

        if (max > 1) { max = (int)(Math.sqrt(1 + 8 * max) - 1) / 2; }
        if (m > 0) { max += 1; }


        return max;
    }

    public static void main(String[] args) {
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
       /* int[][] points = {
                {0,0},
                {1,1},
                {0,0}
        };
        num149 a = new num149();
        System.out.println(a.maxPoints(points));*/

       int n = 65;
       final int MAXIMUM_CAPACITY = 1 << 30;
       n -= 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        int b = 23;
        int c = 32;
        b = b ^ c;
        c = b ^ c;
        b = b ^ c;
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}
