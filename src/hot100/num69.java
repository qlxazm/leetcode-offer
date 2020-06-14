package hot100;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * @author qian
 * @date 2020/1/19 9:30
 */
public class num69 {

    /**
     * 二分查找
     * @param x
     * @return
     */
    /*public int mySqrt(int x) {
        if (x <= 1) {return x;}
        long i = 2, j = x >> 1, temp, middle;
        while (i < j) {
            middle = (i + j) >> 1;
            temp = middle * middle;
            if (temp < x) {
                i = middle + 1;
            } else if (temp > x) {
                j = middle - 1;
            } else {
                return (int)middle;
            }
        }

        return (int)(i * i > x ? i - 1 : i);
    }*/

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        final double ERR = 1e-1;
        double root = x, m = x;
        while (Math.abs(x - root * root) >= ERR) {
            root = (root + m / root) / 2;
        }
        return (int)root;
    }

    public static void main(String[] args) {
        num69 a = new num69();
        System.out.println(a.mySqrt(4));
    }
}
