package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class num56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length, i , j , k;
        int[] lowers = new int[len];
        int[] highers = new int[len];
        for (i = 0; i < len; i++) {
            lowers[i] = intervals[i][0];
            highers[i] = intervals[i][1];
        }

        Arrays.sort(lowers);
        Arrays.sort(highers);

        List<Integer[]> list = new ArrayList<>();
        i = 0;
        j = 0;
        while (i < len) {
            k = i + 1;
            while (k < len && highers[j] >= lowers[k]) {
                j++;
                k++;
            }
            //找到了一个合并后的区间
            Integer[] interval = {lowers[i], highers[j]};
            list.add(interval);

            i = k;
            j++;
        }

        int[][] result = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }

        return result;
    }

    public static void main(String[] args) {
        num56 a = new num56();
        /*int[][] nums = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };*/
        /*int[][] nums = {
                {1,4},
                {4,5}
        };*/
        int[][] nums = {
                {1,6},
                {2,3},
                {8,10},
                {10,12},
                {15,18}
        };

        int[][] result = a.merge(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.println("[" + result[i][0] + ", " + result[i][1] + "]");
        }
    }
}
