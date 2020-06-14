package coder;

/**
 * 看不懂，在等等
 */

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 */
public class num3 {
    public int lengthOfLongestSubstring(String s) {
        for (int i = s.length(); i > 1;i--) {
            if (temp(i, s)) {
                return i;
            }
        }
        return s.equals("") ? 0 : 1;
    }
    public boolean temp (int k, String s) {
        HashSet hashSet = new HashSet<Character>();
        int i = 0;
        boolean first = false;
        while(i <= (k - 1)) {
            char c = s.charAt(i);
            first = c == s.charAt(0);
            hashSet.add(c);
            i++;
        }
        if (hashSet.size() == k) {
            return true;
        }
        for (;i < s.length(); i++) {
            if (!first) {
               hashSet.remove(s.charAt(i - k));
            }
            first = false;
            hashSet.add(s.charAt(i));
            if (hashSet.size() == k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new num3().lengthOfLongestSubstring("aab"));
    }
}
