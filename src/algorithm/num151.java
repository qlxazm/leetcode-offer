package algorithm;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class num151 {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder builder = new StringBuilder();
        char blank = ' ';
        int high = s.length() - 1, lower = 0;
        while(high >= 0) {
            while(high >= 0 && s.charAt(high) == blank) {high--;}
            if(high < 0) {break;}
            lower = high;
            while(lower >= 0 && s.charAt(lower) != blank) {lower--;}
            builder.append(s.substring(lower + 1, high + 1));
            if (lower >= 0) {
                builder.append(blank);
            }
            high = lower - 1;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        num151 num151 = new num151();
        System.out.println(num151.reverseWords(s));
    }
}
