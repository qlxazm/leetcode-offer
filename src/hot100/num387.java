package hot100;

import java.util.HashMap;

/**
 * @author yd
 * @date 2020/3/2 14:47
 */
public class num387 {
    public int firstUniqChar(String s) {
        char[] buffer = new char[26];
        for (int i = 0, len = s.length(); i < len; i++) {
            buffer[s.charAt(i) - 'a']++;
        }

        for (int i = 0, len = s.length(); i < len; i++) {
            if (buffer[s.charAt(i) - 'a'] == 1) {return i;}
        }

        return -1;
    }
}
