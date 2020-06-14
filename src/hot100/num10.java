package hot100;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class num10 {
    public boolean isMatch(String s, String p) {

        int sLen = s.length(), pLen = p.length();
        boolean[][] matchMatrix = new boolean[sLen + 1][pLen + 1];
        matchMatrix[sLen][pLen] = true;

        for (int i = sLen; i >= 0; i--){
            for (int j = pLen - 1; j >= 0; j--) {
                boolean firstMatch = i < sLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < pLen && p.charAt(j + 1) == '*') {
                    matchMatrix[i][j] = matchMatrix[i][j + 2] || (firstMatch && matchMatrix[i + 1][j]);
                }else {
                    matchMatrix[i][j] = firstMatch && matchMatrix[i + 1][j + 1];
                }
            }
        }

        return matchMatrix[0][0];




        /**
         * 回溯法，自底向上构建最优解
         */
      /*if(p.isEmpty()){return s.isEmpty();}
      boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

      if (p.length() >= 2 && p.charAt(1) == '*') {
          return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
      }else {
          return firstMatch && isMatch(s.substring(1), p.substring(1));
      }*/
    }

    public static void main(String[] args) {
        String s = "aab";
        String pattern = "c*a*b";
      /*  String s = "a";
        String pattern = "aa";*/

       /* String s = "aa";
        String pattern = "a*";*/


        num10 a = new num10();

        System.out.println(a.isMatch(s, pattern));

    }
}
