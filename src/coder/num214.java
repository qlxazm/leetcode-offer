package coder;

/**
 * https://leetcode-cn.com/problems/shortest-palindrome/
 */
public class num214 {
    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1){return s;}
        int middle = len / 2;
        int k = -1;

        for (; middle >= 0; middle--){
            //当前和下一个
            boolean currNext = middle + 1 < len && s.charAt(middle) == s.charAt(middle + 1);
            //前一个和后一个
            boolean preNext = middle > 0 && middle + 1 < len && s.charAt(middle - 1) == s.charAt(middle + 1);
            if (currNext) { k = findIndex(s, middle, middle + 1); }

            if (preNext) { k = Math.max(k, findIndex(s, middle - 1, middle + 1)); }

            if (!currNext && !preNext && middle == 0){ k = middle; }

            if (k >= 0) {break;}
        }
        return new StringBuilder(s.substring(k + 1)).reverse().toString() + s;
    }

    private int findIndex(String s, int begin, int end) {
        int result = -1, len = s.length();
        //开始扩展
        while (begin >=0 && end < len) {
            if (s.charAt(begin) != s.charAt(end)) {break;}
            begin--;
            end++;
        }
        if (begin < 0) { result = end - 1; }
        return result;
    }

    public static void main(String[] args) {
//        String s = "aacecaaa";
//        String s = "aaaa";
//        String s = "aaaabbaa";
//        String s = "abb";
//        String s = "caaaaaaa";
        String s = "abcd";
        num214 a = new num214();
        System.out.println(a.shortestPalindrome(s));
    }
}
