package hot100;

/**
 * @author yd
 * @date 2020/3/2 14:42
 */
public class num242 {

    public boolean isAnagram(String s, String t) {
        char[] buffer = new char[26];
        for(char c : s.toCharArray()) {
            buffer[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            buffer[c - 'a']--;
        }
        for (char c : buffer) {
            if (c != 0) {return false;}
        }

        return true;
    }

}
