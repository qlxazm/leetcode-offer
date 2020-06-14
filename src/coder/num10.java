package coder;

public class num10 {
    public boolean isMatch(String s, String p) {
        int sL = s.length();
        int pL = p.length();
        if (sL == 0) {
            return (pL == 0 || p.equals(".*"));
        }

        boolean[][] table = new boolean[sL + 1][pL + 1];
        int i = 0;
        int j = 0;
        for (; i <= sL; i++) {table[i][pL] = true;}
        for (;j <= pL; j++){table[sL][j] = true;}

        i = sL - 1;
        j = pL - 1;
        while(i >= 0) {
            while (j >= 0) {
                if (p.charAt(j) == '*') {
                    table[i][j] = false;
                    j--;
                    if (table[i][j + 2]) {
                        table[i][j] = true;
                    } else {
                        table[i][j] =  table[i + 1][j + 2] && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                    }
                    j--;
                    continue;
                }
                if(table[i + 1][j + 1]) {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                        table[i][j] = true;
                    }else {
                        table[i][j] = false;
                    }
                }
                j--;
            }
            i--;
            j = pL - 1;
        }
        return table[0][0];
    }

    public static void main (String[] args) {
        boolean result = new num10().isMatch("aab", "c*a*b");
        System.out.println(result);
    }
}
