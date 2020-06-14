package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class num128 {
    public int longestConsecutive(int[] nums) {
        /*
        方法1：
        先排序，后统计长度（需要注意跳过重复值）
        Arrays.sort(nums);
        int i = 0, len = nums.length, result = len > 0 ? 1 : 0, begin = 0;
        for (; i < len - 1; i++) {
            // 跳过重复值
            if (nums[i + 1] == nums[i]) {
                begin++;
                continue;
            }
            if (nums[i + 1] - 1 != nums[i]) {
                result = Math.max(result, i - begin + 1);
                begin = i + 1;
            }
        }
        result = Math.max(result, i - begin + 1);
        return result;*/

        // 方法2：使用Set去重后执行
        Set<Integer> set = new HashSet<>();
        // 去重
        for (int num : nums) {set.add(num);}
        int result = 0;
        for (int num : nums) {
            // 保证当前 num 中存放的是一个序列的开头
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(++num)){
                    count++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        num128 a = new num128();
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0, -1};
        int[] nums = {1, 2, 0, 1};
        System.out.println(a.longestConsecutive(nums));
    }
}
