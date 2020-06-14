package hot100;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * @author qian
 * @date 2020/1/19 20:56
 */
public class num91 {

    public int numDecodings(String s) {

        int len = s.length();
        char c;
        int[] dp = new int[len];

        // 初始化
        c = s.charAt(len - 1);
        if (c != '0') {dp[len - 1] =  1;}
        if (len > 1 && s.charAt(len - 2) > '0') {
            c= s.charAt(len - 2);
            if (c == '1') {
                dp[len - 2] = s.charAt(len - 1) == '0' ? 1 : 2;
            } else if (c == '2') {
                dp[len - 2] = s.charAt(len - 1) == '0' || s.charAt(len - 1) > '6' ? 1 : 2;
            } else {
                dp[len - 2] = s.charAt(len - 1) == '0' ? 0 : 1;
            }
        }

        for (int i = len - 3; i >= 0; i--) {
            c = s.charAt(i);
            if (c > '0') {
                if (c == '1') {
                    dp[i] = s.charAt(i + 1) == '0' ? dp[i + 2] : dp[i + 1] + dp[i + 2];
                }else if (c == '2') {
                    dp[i] = s.charAt(i + 1) == '0' || s.charAt(i + 1) > '6' ? dp[i + 2] : dp[i + 1] + dp[i + 2];
                }else {
                    dp[i] = s.charAt(i + 1) == '0' ? 0 : dp[i + 1];
                }
            }
        }

        return dp[0];
    }

    private int numDecodings(String s, int i, final int len) {
        int ans = 0;
        int next = s.charAt(i) - '0';
        if(next == 0) {return ans;}
        if(i + 1 < len) { next = next * 10 + (s.charAt(i + 1) - '0'); }

        if (next == 10 || next == 20) {
            // 逢10的只能使用两个
            ans += i + 2 >= len ? 1 : numDecodings(s, i + 2, len);
        } else if (next > 26 || next < 10){
            // 只能使用一个进行解答
            ans += i + 1 >= len ? 1 : numDecodings(s, i + 1, len);
        } else{
            // 两个都可以使用
            ans += i + 1 >= len ? 1 : numDecodings(s, i + 1, len);
            ans += i + 2 >= len ? 1 : numDecodings(s, i + 2, len);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "611";
        num91 a = new num91();
        System.out.println(a.numDecodings(s));
    }
}
