package algorithm;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class num11 {

    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int k = Math.min(height[i], height[j]);
            ans = Math.max(ans, k * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
