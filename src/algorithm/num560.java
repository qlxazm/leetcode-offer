package algorithm;

import java.util.HashMap;

/**
 */
public class num560 {

    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化
        map.put(0, 1);

        // 计算前缀和
        int ans = 0;
        Integer m = null;
        for (int i = 1; i <= len; i++) {
            sum += nums[i - 1];
            if ((m = map.get(sum - k)) != null) {
                ans += m;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
