package hot100;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author qian
 * @date 2020/1/16 14:02
 */
public class num8 {

    public int myAtoi(String str) {
        int i = 0, len = str.length();
        // 标识是否是负数
        boolean isNegative = false, isExceed = false;

        // 跳过所有的空白符
        while (i < len && str.charAt(i) == ' ') { i++;}

        if (i < len && str.charAt(i) == '+') {
            i++;
        } else if (i < len && str.charAt(i) == '-') {
            i++;
            isNegative = true;
        }

        long ans = 0;
        while (i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            ans = ans * 10 + str.charAt(i) - '0';
            // 检查出越界
            if ((int)ans != ans) {
                isExceed = true;
                break;
            }
            i++;
        }
        //如果每越界
        if (!isExceed) {
            ans *= isNegative ? -1 : 1;
        }else {
            ans = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        num8 a = new num8();
        System.out.println(a.myAtoi("2147483648"));
    }
}
