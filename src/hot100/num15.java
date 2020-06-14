package hot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class num15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        int i, first, last, len = nums.length;

        if (len > 2 && (nums[0] > 0 || nums[len - 1] < 0)){
            // 元素全大于0或者全小于0就直接返回
            return results;
        }

        for (i = 0; i < len - 2; i++) {
            first = i + 1;
            last = len - 1;
            // 如果当前大于0，就不可能有等于0的组合
            if (nums[i] > 0) { break; }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]){continue;}

            while (first < last) {
                int temp = nums[i] + nums[first] + nums[last];

                // 提前终止
                if (nums[i] < 0 && nums[last] < 0) {break;}

                if (temp > 0) {
                    last--;
                }else if (temp < 0) {
                    first++;
                }else {
                    results.add(Arrays.asList(nums[first], nums[i], nums[last]));
                    //两边去重
                    while (first < len - 1 && nums[first] == nums[first + 1]){first++;}
                    while (last > 0 && nums[last] == nums[last - 1]){last--;}
                    first++;
                    last--;
                }
            }
        }

        return results;
    }

    public void show(List<List<Integer>> lists) {
        for (int i = 0, len = lists.size(); i < len; i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0, len1 = list.size(); j < len1; j++) {
                System.out.print(list.get(j) + ",");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        num15 a = new num15();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {0, 0, 0};
        List<List<Integer>> b = a.threeSum(nums);
        a.show(b);

       /* Set<ThreeNum> set = new HashSet<>();
        set.add(new ThreeNum(1,1,1));
        if (set.contains(new ThreeNum(1,1,1))) {
            System.out.println("包含啦");
        }*/

       /* List<List<Integer>> c = new ArrayList<>();

        ArrayList<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(-1);
        d.add(0);

        ArrayList<Integer> e = new ArrayList<>();
        e.add(1);
        e.add(-1);
        e.add(0);

        c.add(d);
        System.out.println(c.contains(e));*/
    }
}
