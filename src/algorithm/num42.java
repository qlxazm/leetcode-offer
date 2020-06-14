package algorithm;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class num42 {

    /**
     * 最大值会把问题切分成两个
     * @param height
     * @return
     */
    public int trap(int[] height){
        int maxIndex = 0, len = height.length;
        for (int k = 1; k < len; k++) {
            if (height[k] > height[maxIndex]) {
                maxIndex = k;
            }
        }
        int ans = 0;
        int i = 1, j = 0;
        while (i <= maxIndex) {
            while (i <= maxIndex && height[i] < height[j]) {
                ans -= height[i];
                i++;
            }
            ans += Math.min(height[j], height[i]) * (i - j - 1);
            j = i;
            i++;
        }

        i = len - 2;
        j = len - 1;
        while (i >= maxIndex) {
            while (i >= maxIndex && height[i] < height[j]) {
                ans -= height[i];
                i--;
            }
            ans += Math.min(height[j], height[i]) * (j - i - 1);
            j = i;
            i--;
        }

        return ans;
    }

}
