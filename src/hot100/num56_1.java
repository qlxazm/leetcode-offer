package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 */
public class num56_1 {

    static class Range {
        int lower;
        int hight;

        public Range(int lower, int hight) {
            this.lower = lower;
            this.hight = hight;
        }
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {return intervals;}

       /* Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            ranges[i] = new Range(intervals[i][0], intervals[i][1]);
        }*/

//        Arrays.sort(ranges, (a, b) -> {return a.lower - b.lower;});
        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0];});

        List<Integer> lower = new ArrayList<>();
        List<Integer> high = new ArrayList<>();

        int k = 1, i = intervals[0][0], j = intervals[0][1];
        while (k < n) {
            if (intervals[k][0] <= j) {
                j = Math.max(j, intervals[k][1]);
            } else {
                // 产生了一个结果
                lower.add(i);
                high.add(j);

                i = intervals[k][0];
                j = intervals[k][1];
            }
            k++;
        }

        lower.add(i);
        high.add(j);

        n = lower.size();
        int[][] ans = new int[n][2];
        for (i = 0; i < n; i++) {
            ans[i][0] = lower.get(i);
            ans[i][1] = high.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        num56_1 num56_1 = new num56_1();
        int[][] ans = num56_1.merge(nums);
        for (int[] n : ans) {
            System.out.println(n[0] + "," + n[1]);
        }
    }
}
