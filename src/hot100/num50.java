package hot100;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * @author qian
 * @date 2020/1/18 21:53
 */
public class num50 {

    public double myPow(double x, int n) {
        if (n == 0) {return 1;}

        // 转换成正数
        long m = n;
        if (m < 0) { m = -m; }

        double ans = 1;
        while (m >= 2) {
            long k = 2;
            double temp = x;
            while (k <= m) {
                temp *= temp;
                k = k << 1;
            }
            m -= k >> 1;
            ans *= temp;
        }

        if (m == 1) { ans *= x; }

        return n < 0 ? 1 / ans : ans;
    }

    public static void main(String[] args) {
        num50 a = new num50();

//        System.out.println(a.myPow(0.00001, 2147483647));
        System.out.println(a.myPow(2.00000, -2147483648));
//        System.out.println(a.myPow(2.0000, 10));
    }
}
