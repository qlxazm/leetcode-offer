package hot100;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * @author qian
 * @date 2020/3/2 14:58
 */
public class num541 {

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int L = charArray.length, i = 0;
        while (i < L) {
            reverse(charArray, i, i + Math.min(k, L - i) - 1);
            i += 2 * k;
        }
        return new String(charArray);
    }

    private void reverse(char[] charArray, int l, int h) {
        while (l <= h) {
            char temp = charArray[h];
            charArray[h] = charArray[l];
            charArray[l] = temp;
            l++;
            h--;
        }
    }

    public static void main(String[] args) {
        num541 a = new num541();
        String s = "abcdefg";
        int k = 8;
        System.out.println(a.reverseStr(s, k));
    }

}
