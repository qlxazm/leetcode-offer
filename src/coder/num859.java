package coder;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 */
public class num859 {
    public boolean buddyStrings(String A, String B) {
        boolean result = false;
        int len = A.length(), diffNum = 0, i = 0, firstIndex = -1, lastIndex = -1;
        if (len != B.length()) { return false;}

        char a, b;
        int[] sames = new int[26];

        for (; i < len; i++) {
            a = A.charAt(i);
            b = B.charAt(i);
            if (a != b) {
                diffNum++;
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    lastIndex = i;
                }
            }else {
                sames[a - 'a']++;
            }
        }

        if (diffNum == 2 && A.charAt(firstIndex) == B.charAt(lastIndex) && B.charAt(firstIndex) == A.charAt(lastIndex)) {
            result = true;
        }else if (diffNum == 0) {
            for (i = 0; i < 26; i++) {
                if (sames[i] >= 2) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        num859 a = new num859();
        String A = "aba";
        String B = "aab";
        System.out.println(a.buddyStrings(A, B));
    }
}