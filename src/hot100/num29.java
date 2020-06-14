package hot100;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * @author qian
 * @date 2020/1/16 18:05
 */
public class num29 {

    public int divide(int dividend, int divisor) {
        // 统一成正整数相除
        boolean isDiff = dividend < 0 ^ divisor < 0;

        long m = dividend, n = divisor;
        if (dividend < 0) {m = -m;}
        if (divisor < 0) {n = -n;}

        long index;
        long count = 0, k;

        while (m >= n) {

            k = n;
            index = 1;

            while (k <= m) {
                k = k << 1;
                index = index << 1;
            }

            m -= k >> 1;
            count += index >> 1;

            // 溢出检查
            if ((isDiff && count < Integer.MIN_VALUE) || (!isDiff && count > Integer.MAX_VALUE)) {
                return Integer.MAX_VALUE;
            }
        }

        return isDiff ? -(int)count : (int)count;
    }

    public static void main(String[] args) {

        num29 a = new num29();

        System.out.println(a.divide(7, -3));
    }
}
