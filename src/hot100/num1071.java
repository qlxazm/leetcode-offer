package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 */
public class num1071 {

    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int i, j = 0, k;
        String gcd;
        List<String> gcds = new ArrayList<>();
        for (i = 1; i <= m / 2; i++) {
            gcd = str1.substring(0, i);
            k = 0;
            while ((k = k + i) < m) {
                for (j = 0; k < m && j < gcd.length(); j++, k++) {
                    if (str1.charAt(j) != str1.charAt(k)) { break; }
                }
                if (j != gcd.length()) {break;}
            }
            if (j == gcd.length()) {gcds.add(str1.substring(0, i));}
        }
        gcds.add(str1);

        for (i = gcds.size() - 1; i >= 0; i--) {
            gcd = gcds.get(i);
            int gcdLen = gcd.length();
            if (n % gcdLen == 0) {
               StringBuilder builder = new StringBuilder();
               for (j = 0; j < n / gcdLen; j++) {
                    builder.append(gcd);
               }
               if (builder.toString().equals(str2)) {return gcd;}
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String str1 = "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM";
        String str2 = "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM";

        num1071 a = new num1071();
        System.out.println(a.gcdOfStrings(str1, str2));
    }
}
