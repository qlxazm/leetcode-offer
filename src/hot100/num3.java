package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class num3 {
    /**
     * 我的答案，时间复杂度O(n*n)
     * 空间复杂度O(K),其中K是整个字符集的大小
     * @param s
     * @return
     */
    /*public int lengthOfLongestSubstring(String s) {
        int len = s.length(), i, j, count, max = -1;
        if (len <= 1) {return len;}
        boolean[] isPresent = null;

        for (i = 0; i < len; i++){
            isPresent = new boolean[128];
            for (j = i, count = 0; j < len; j++){
                int index = s.charAt(j) - 32;
                if (isPresent[index]){break;}
                isPresent[index] = true;
                count++;
            }
            max = Math.max(count, max);
        }

        return max;
    }*/

    /**
     * 基本版的滑动窗口协议
     * @param s
     * @return
     */
    /*public int lengthOfLongestSubstring(String s) {
        int max, i, j, len = s.length();
        Set<Character> set = new HashSet<>();
        max = i = j = 0;
        while (i < len && j < len) {
            // 如果当前的字符不重复就移动j，并计算最长不重复字符串的长度
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }else {
                // 如果当前字符重复了，就移动i，知道不重复为止
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }*/

    /**
     * 优化版本的滑动窗口协议，存储了字符的出现位置
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int i, j, len = s.length(), max;
        i = j = max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (j < len) {
            if (map.containsKey(s.charAt(j))) {
                //更换i的位置
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        num3 a = new num3();
//        String s = "abcabcbb";
//        String s = "bbbbbb";
  //      String s = "pwwkew";
        System.out.println(a.lengthOfLongestSubstring("abba"));
    }
}
