package algorithm;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class num242 {

    public boolean isAnagram(String s, String t) {
        int[][] buffer = new int[2][26];
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2 || s.equals(t)) {return false;}
        for(int i = 0; i < len1; i++) {
            buffer[0][s.charAt(i) - 'a']++;
            buffer[1][t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(buffer[0][i] != buffer[1][i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        num242 num242 = new num242();
        System.out.println(num242.isAnagram("nl", "cx"));
    }
}
