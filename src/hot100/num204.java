package hot100;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/count-primes/
 * @author qian
 * @date 2020/2/7 20:24
 */
public class num204 {



    public int countPrimes(int n) {

        if (n <= 1) {return 0;}

        // 标记
        boolean[] marks = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            for (int j = i; j <= n / i; j++) {
                marks[i * j] = true;
            }
        }

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!marks[i]) {ans++;}
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
