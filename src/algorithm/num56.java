package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-intervals/submissions/
 */
public class num56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)-> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int i = 1, len = intervals.length;
        if (len == 0) {return new int[][]{};}

        ArrayList<Integer[]> ans = new ArrayList<>();
        int[] last = {intervals[0][0], intervals[0][1]}, curr = null;
        while (i < len) {
            curr = intervals[i];
            // 出现重叠区间
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                ans.add(new Integer[]{last[0], last[1]});
                last[0] = curr[0];
                last[1] = curr[1];
            }
            i++;
        }

        // 处理最后一个
        ans.add(new Integer[]{last[0], last[1]});

        int size = ans.size();
        int[][] res = new int[size][2];
        i = 0;
        for (Integer[] pair : ans) {
            res[i] = new int[]{pair[0], pair[1]};
            i++;
        }
        return res;
    }
}
