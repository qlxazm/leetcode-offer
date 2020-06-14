package algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
 */
public class num3 {

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, len = s.length();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;

        while (right < len) {
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);
            right++;

            while (window.get(c1) > 1) {
                char c2 = s.charAt(left);
                if (window.get(c2) == 1) {
                    window.remove(c2);
                } else {
                    window.put(c2, 1);
                }
                left++;
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int len = charArray.length, i, j;
        for (i = 0, j = 0; j < len; j++) {
            char c = charArray[j];
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                ans = Math.max(ans, j - i);
                char c1 = charArray[i];
                map.put(c1, map.get(c1) - 1);
                i++;
            }
        }
        ans = Math.max(ans, j - i);
        return ans;
    }

    public static void main(String[] args) {
        num3 num3 = new num3();
        System.out.println(num3.lengthOfLongestSubstring1("au"));
    }

}
