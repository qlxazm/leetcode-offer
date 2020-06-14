package hot100;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class num11 {
    public int maxArea(int[] height) {
        int len = height.length, max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        num11 a = new num11();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(a.maxArea(height));
    }
}
