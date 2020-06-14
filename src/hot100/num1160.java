package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class num1160 {
    public int countCharacters(String[] words, String chars) {
        char[] charArray = chars.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < charArray.length; i++) {map[charArray[i] - 'a']++;}

        int ans = 0, i = 0;
        for (String word : words) {
            charArray = word.toCharArray();
            for (i = 0; i < charArray.length && map[charArray[i] - 'a'] > 0; i++) {
                map[charArray[i] - 'a']--;
            }
            if (i == charArray.length) { ans += charArray.length; }
            // 修正原来的
            for (int j = 0; j < i; j++) {
                map[charArray[j] - 'a']++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        num1160 a = new num1160();
        System.out.println(a.countCharacters(words, chars));
    }
}
