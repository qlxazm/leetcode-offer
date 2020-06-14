package hot100;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class num32 {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] counts = new int[len];

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == OPEN && s.charAt(i + 1) == CLOSE){
                counts[i] = 1;
            }
        }

        // 开始扩展
        boolean flag = false;
        do {
            flag = false;
            for (int i = 0; i < len; i++){
                if (counts[i] != 0) {
                    //先是相邻扩展，就是像 ()() 这样紧挨着的情况
                    int k = i;
                    while (k < len && counts[k] != 0) {
                        if (k > i) {
                            // 这一趟是否发生了更新
                            flag = true;
                        }
                        int oldKey = k;
                        k = k + counts[k] + 1;
                        counts[oldKey] = 0;
                    }
                    k--;
                    counts[i] = k - i;
                    // 优化，跳过一些无用值
                    int j = i;
                    i = k;

                    //看看是否可以包含扩展，就是像这样 (()()) 包含着的情况
                    if (j - 1 >= 0 && k < len - 1 && s.charAt(j - 1) == OPEN && s.charAt(k + 1) == CLOSE) {
                        counts[j - 1] = k + 1 - (j - 1);
                        counts[j] = 0;
                        // 这一趟是否发生了更新
                        flag = true;
                        // 优化，跳过一些无用值
                        i = k + 1;
                    }
                }
            }
        }while (flag);

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(counts[i], max);
        }


        return max + 1;

        // 找到所有的最小范围的括号并开始扩展
       /* for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == OPEN && s.charAt(i + 1) == CLOSE){
                //开始扩展
                int begin = i, end = i + 1;
                while (begin >= 0 && end < len && s.charAt(begin) == OPEN && s.charAt(end) == CLOSE) {
                    counts[begin] = end - begin;
                    begin--;
                    end++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            if (counts[i] != 0) {
                int temp = 0;
                int k = i;
                while (k < len && counts[k] > 0) {
                    temp += counts[k] + 1;
                    k = k + counts[k] + 1;
                }
                max = Math.max(max, temp);
            }
        }
        return max;*/
    }

    public boolean isValid(String s, int begin, int end) {



        return false;
       /* while (begin < s.length() && s.charAt(begin) != OPEN) { begin++; }
        while (end >= 0 && s.charAt(end) != CLOSE){ end--; }


        if (begin == s.length() || end == 0){return false;}
        if (end - begin == 1) {
            longestStr = Math.max(longestStr, 2);
            return true;
        }
        int i, j;

        //当前找到的括号是否正确配对
        if (isValid(s, begin + 1, end - 1)) {
            longestStr = Math.max(end - begin + 1, longestStr);
            return true;
        }


        //找到与左括号匹配的右括号
        for (i = end - 1; i > begin; i--) {
            if (s.charAt(i) == OPEN) {continue;}
            if (isValid(s, begin, i)){
                longestStr = Math.max(longestStr, i - begin + 1);
                return false;
            }
        }
        //找到与右括号匹配的左括号
        for (j = begin + 1; j < end; j++) {
            if (s.charAt(j) == CLOSE) {continue;}
            if (isValid(s, j, end)){
                longestStr = Math.max(longestStr, end - j + 1);
                return false;
            }
        }*/
    }

    public static void main(String[] args) {
        num32 a = new num32();
//        String s = ")()())";
//        String s = "(()";
//        String s = "((()())(()()))";
//        String s = ")(";
        String s = ")()())";
        System.out.println(a.longestValidParentheses(s));
    }
}
