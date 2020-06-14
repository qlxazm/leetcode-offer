package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qian
 * @date 2020/1/6 10:02
 */
public class num438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s.length() < p.length()) {return results;}

        int i = 0, len = p.length();
        final int CAPACITY = 26;
        int[] patternBuffer = new int[CAPACITY], workBuffer = new int[CAPACITY];

        for (; i < len; i++) {
           patternBuffer[p.charAt(i) - 'a'] += 1;
           workBuffer[s.charAt(i) - 'a'] += 1;
        }

        int j = i, k;
        i = 0;
        len = s.length();
        while (j <= len) {
            // 检测是不是字母异位词
            for (k = 0; k < CAPACITY; k++){
                if (patternBuffer[k] != workBuffer[k]) {break;}
            }
            if (k == CAPACITY) {results.add(i);}

            // 移动指针
            if (j < len) {
                workBuffer[s.charAt(i) - 'a'] -= 1;
                workBuffer[s.charAt(j) - 'a'] += 1;
            }
            i++;
            j++;
        }

        return results;
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        num438 a = new num438();

        List<Integer> result = a.findAnagrams(s, p);

        for (int num : result) {
            System.out.print(num + ", ");
        }


    }
}
