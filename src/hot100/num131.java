package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * @author qian
 * @date 2020/1/28 11:21
 */
public class num131 {

    public List<List<String>> partition(String s) {

        // 找出所有的回文子串
        int L = s.length();
        boolean[][] buffer = new boolean[L][L];
        for (int i = 0; i < L; i++) { buffer[i][i] = true; }
        for (int k = 2; k <= L; k++) {
            for (int i = 0; i <= L - k; i++) {
                buffer[i][i + k - 1] = s.charAt(i) == s.charAt(i + k - 1) && (k == 2 || buffer[i + 1][i + k - 2]);
            }
        }
        // 根据回文子串构建结果
        return partition(s, 0, L, buffer);
    }

    private List<List<String>> partition(String s, int begin, final int L, boolean[][] buffer) {

        List<List<String>> ans = new ArrayList<>();

        if (begin == L) { ans.add(new ArrayList<>());}

        for (int i = begin; i < L; i++) {
            if (!buffer[begin][i]) {continue;}
            String subStr = s.substring(begin, i + 1);
            List<List<String>> tempResult = partition(s, i + 1, L, buffer);
            for (List<String> list : tempResult) {
                list.add(0, subStr);
                ans.add(list);
            }
        }
        return ans;
    }

    public List<List<String>> partition1(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        // 标记出所有的回文子串
        int k = 0, i, j;
        while (k < 2 * len - 1) {
            // 中心扩展
            i = j = k;
            while (i >= 0 && j < 2 * len - 1) {
                if ((i & 1) == 0) {
                    if (s.charAt(i / 2) != s.charAt(j / 2)) {break;}
                    dp[i / 2][j / 2] = true;
                }
                i--;
                j++;
            }
            k++;
        }

        return partition1(s, 0, len , dp);
    }

    public List<List<String>> partition1(String s, int start, int len, boolean[][] dp) {

        List<List<String>> ans = new ArrayList<>();
        if (start < len) {
            String prefix;
            for (int i = start; i < len; i++) {
                if (dp[start][i]) {
                    prefix = s.substring(start, i + 1);
                    List<List<String>> tempLists = partition1(s, i + 1, len, dp);
                    if (tempLists.size() == 0) {
                        List<String> oneList = new ArrayList<>();
                        oneList.add(prefix);
                        ans.add(oneList);
                    } else {
                        for (List<String> tempList : tempLists) {
                            tempList.add(0, prefix);
                            ans.add(tempList);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abbab";
        num131 a = new num131();

        List<List<String>> ans = a.partition1(s);

        for (List<String> list : ans) {
            System.out.println(list);
        }

        /*List<String> temp = null;

        for (int i = 0; i < ans.size(); i++) {
            temp = ans.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + ",");
            }
            System.out.println("");
        }*/
    }
}
