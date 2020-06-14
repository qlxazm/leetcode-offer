package algorithm;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class num125 {

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length, i = 0, j = len - 1;
        if (len == 0) {return true;}
        while (i < len && j >= 0) {
            while (i < len && !isCharacter(charArray[i])) {
                i++;
            }
            while (j >= 0 && !isCharacter(charArray[j])) {
                j--;
            }
            if (!isEquals(charArray[i], charArray[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isCharacter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private boolean isEquals(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public static void main(String[] args) {
        num125 num125 = new num125();
        System.out.println(num125.isPalindrome("0P"));
    }

}
