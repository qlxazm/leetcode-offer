package other;

/**
 *https://leetcode-cn.com/problems/compress-string-lcci/s
 */
public class CompressString {

    public String compressString(String S) {
        char[] chars = S.toCharArray();
        int i = 1, count = 1, len = chars.length;
        char last;
        StringBuilder builder = new StringBuilder();
        if (len > 0) {
            last = chars[0];
            for (; i < len; i++) {
                if (chars[i] != last) {
                    builder.append(last);
                    builder.append(count);
                    last = chars[i];
                    count = 0;
                }
                count++;
            }
            builder.append(last);
            builder.append(count);
        }
        String ans = builder.toString();
        return ans.length() >= S.length() ? S : ans;
    }

}
