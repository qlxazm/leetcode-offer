package hot100;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @author qian
 * @date 2020/2/5 15:50
 */
public class num172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5){
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1808548329;
        num172 a = new num172();
        System.out.println(a.trailingZeroes(n));
    }
}
