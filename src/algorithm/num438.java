package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class num438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int ls = s.length(), lp = p.length();
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        char c = 0;
        for (int i = 0; i < lp; i++) {
            c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, matches = 0;
        while (right < ls) {
            // 一直扩大直到符合要求
            c = s.charAt(right);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    matches++;
                }
            }
            right++;

            while (matches == needs.size()) {
                if ((right - left) == lp) {
                    ans.add(left);
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
        return ans;
    }


}
