package algorithm;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 */
public class FlipedString {

    public boolean isFlipedString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {return false;}
        if (s1.equals(s2)) {return true;}

        s1 += s1;
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        FlipedString flipedString = new FlipedString();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(flipedString.isFlipedString(s1, s2));
    }
}
