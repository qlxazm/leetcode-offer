package hot100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * @author qian
 * @date 2020/2/5 17:00
 */
public class num179 {

    static class StrNum implements Comparable<StrNum> {
        String num;

        public StrNum(String num) {
            this.num = num;
        }

        @Override
        public int compareTo(StrNum o) {
            String a = this.num + o.num;
            String b = o.num + this.num;
            return b.compareTo(a);
        }
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        StrNum[] strNums = new StrNum[n];
        for (int i = 0; i < n; i++) {
            strNums[i] = new StrNum(String.valueOf(nums[i]));
        }

        Arrays.sort(strNums);

        StringBuilder builder = new StringBuilder();
        for (StrNum s : strNums) { builder.append(s.num); }

        String ans = builder.toString();
        ans = ans.charAt(0) == '0' ? "0" : ans;

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {999999998,999999997,999999999};
        num179 a = new num179();
        System.out.println(a.largestNumber(nums));
    }

}
