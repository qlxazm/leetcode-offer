package algorithm;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class num76 {

    public String minWindow(String s, String t) {
        int x = 0, y = Integer.MAX_VALUE;

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        char c = 0;
        for (int i = 0, len = t.length(); i < len; i++) {
            c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, len = s.length(), matches = 0;
        while (right < len) {
            c = s.charAt(right);
            // 不断扩大right直到满足要求
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    matches++;
                }
            }
            right++;

            // 发现窗口已经符合要求，就移动left
            while (matches == needs.size()) {
                // 更新答案
                if ((right - left) < (y - x)) {
                    x = left;
                    y = right;
                }

                c = s.charAt(left);
                if (needs.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) < needs.get(c)) {
                        matches--;
                    }
                }
                left++;
            }
        }

        return y == Integer.MAX_VALUE ? "" : s.substring(x, y);
    }

    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(s.substring(0, 1));
    }
}
