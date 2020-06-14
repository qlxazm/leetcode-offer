package hot100;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @author qian
 * @date 2020/2/5 15:41
 */
public class num171 {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            ans = ans * 26 + s.charAt(i) - 'A' + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        num171 a = new num171();
        System.out.println(a.titleToNumber("ZY"));
    }
}
