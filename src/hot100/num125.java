package hot100;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 * @author qian
 * @date 2020/1/27 16:14
 */
public class num125 {

    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int l = 0, len = s.length(), h = len - 1;
        while (l <= h) {
            while (l < len && !isCharacterOrDigit(s.charAt(l))) {
                l++;
            }

            while (l <= h && !isCharacterOrDigit(s.charAt(h))) {
                h--;
            }

            if (l <= h && s.charAt(l) != s.charAt(h)) { return false; }
            l++;
            h--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        int len = s.length(), lower = 0, higher = len - 1;
        while(lower <= higher) {
            while(lower <= higher && !isCharacter1(s.charAt(lower))) { lower++; }
            while(higher >= lower && !isCharacter1(s.charAt(higher))) { higher--; }
            if (lower <= higher) {
                if(!isEqual(s.charAt(lower), s.charAt(higher))) { return false; }
                lower++;
                higher--;
            }
        }
        return true;
    }

    private boolean isCharacter1(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    private boolean isEqual(char a, char b) {
        return a == b || String.valueOf(a).toLowerCase().equals(String.valueOf(b).toLowerCase());
    }

    private boolean isCharacterOrDigit(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        num125 a = new num125();
//        String s = "race a car";
        String s = "0P";
        System.out.println(a.isPalindrome1(s));
    }
}
