package hot100;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * @author qian
 * @date 2020/1/19 9:22
 */
public class num66 {

    public int[] plusOne(int[] digits) {

        int temp = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp += digits[i];
            digits[i] = temp % 10;
            temp /= 10;
        }

        if (temp != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = temp;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        }

        return digits;
    }

    public static void main(String[] args) {

    }
}
