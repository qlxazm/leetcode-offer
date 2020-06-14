package hot100;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class num76 {
    public String minWindow(String s, String t) {
        int i = 0, j = 0, len = s.length(), lower = 1, hight = Integer.MAX_VALUE;
        final int CHARACTER_NUM = 58;
        int[] buffer1 = null;
        int[] buffer2 = new int[CHARACTER_NUM];

        //计算目标串t的字符的出现数量
        for (i = 0; i < t.length(); i++) {
            buffer2[t.charAt(i) - 'A']++;
        }


        i = j = 0;
        while (i < len) {
            buffer1 = new int[CHARACTER_NUM];
            //先让j去探测，一直探测到一个合适的子串的最右边。当循环退出时，j就指向了子串的最右端。
            while (j < len){
                buffer1[s.charAt(j) - 'A']++;
                if (isContain(buffer1, buffer2)){break;}
                j++;
            }
            //什么都没有探测到，提前结束
            if (j == len) {break;}

            //再让i去探测，一直探测到合适子串的最左边。
            buffer1 = new int[CHARACTER_NUM];
            i = j;
            while (i >= 0){
                buffer1[s.charAt(i) - 'A']++;
                if (isContain(buffer1, buffer2)){ break;}
                i--;
            }

            //现在i，j就是探测到的合适的子串
            if (j - i < hight - lower){
                lower = i;
                hight = j;
            }
            i = j = i + 1;
        }
        return hight == Integer.MAX_VALUE ? "" : s.substring(lower, hight + 1);
    }

    public boolean isContain(int[] buffer1, int[] buffer2) {
        for (int i = 0, len = buffer1.length; i < len; i++){
            if (buffer2[i] != 0 && buffer1[i] < buffer2[i]){return false;}
        }
        return true;
    };

    public static void main(String[] args){
        num76 a = new num76();
        /*String s = "ADOBECODEBANC";
        String t = "BANC";*/
       /* String s = "a";
        String t = "a";*/
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(a.minWindow(s, t));
//        System.out.println(a.isContain(s, 0, s.length() - 1, t));
    }
}
