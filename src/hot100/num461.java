package hot100;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author qian
 * @date 2020/1/6 14:56
 */
public class num461 {
    public int hammingDistance(int x, int y) {
        x = x ^ y;
        y = 0;
        while (x != 0) {
            if ((x & 1) == 1) {y++;}
            x = x >> 1;
        }
        return y;
    }

    public static void main(String[] args) {
        num461 a = new num461();
        System.out.print(a.hammingDistance(1, 4));
    }
}
