package hot100;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * @author qian
 * @date 2020/2/5 20:16
 */
public class num190 {

    private static int[] dict = new int[31];

    static {
        for (int i = 0, k = 1; i < 31; i++, k *= 2) { dict[i] = k; }
    }

    public int reverseBits(int n) {
        /*int i = 1, j = 30;
        while (i < j) {
            int a = n & dict[i], b = n & dict[j];
            boolean isSome = (a > 0 && b > 0) || (a == 0 && b == 0);
            if (!isSome) {
                n += a == 0 ? dict[i] : -dict[i];
                n += b == 0 ? dict[j] : -dict[j];
            }
            i++;
            j--;
        }
        // 由于int型数的范围问题，特殊处理一下符号位置
        if (n > 0 && (n & 1) == 1) {
            n -= 1;
            n = n == 0 ? Integer.MIN_VALUE : -n;
        } else if (n < 0 && (n & 1) == 0) {
            n += 1;
            n = n == 0 ? Integer.MAX_VALUE : -n;
        }

        return n;*/

        int ans = 0;
        for (int i = 0, j = 31; i < 32; i++, j--) {
            ans += (n & 1) << j;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        num190 a = new num190();
//        System.out.println(a.reverseBits(-3));
        System.out.println(a.reverseBits(1));
    }
}
