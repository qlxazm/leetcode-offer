package other;

import java.util.Arrays;

/**
 * @author yd
 * @date 2020/4/11 20:23
 */
public class Boxes {

    static class Boxe {
        int L;
        int W;
        int H;

        public Boxe(int l, int w, int h) {
            L = l;
            W = w;
            H = h;
        }
    }

    /**
     *
     * @param boxes int整型二维数组
     * @return int整型
     */
    public int maxBoxes (int[][] boxes) {
        int len = boxes.length, i = 0;
        if (len == 0) {return 0;}
        Boxe[] boxe = new Boxe[len];
        while (i < len) {
            boxe[i] = new Boxe(boxes[i][0], boxes[i][1], boxes[i][2]);
            i++;
        }
        // 排序
        Arrays.sort(boxe, ((o1, o2) -> {
            if (o1.H != o2.H) {
                return o2.H - o1.H;
            }
            if (o1.L != o2.L) {
                return o2.L - o1.L;
            }

            if (o1.W != o2.W) {
                return o2.W - o1.W;
            }

            return 0;
        }));

        // 计算值
        int[] dp = new int[len];
        i = 0;
        while (i < len) {dp[i++] = 1;}

        i = len - 2;
        while (i >= 0) {
            int j = i + 1;
            while (j < len) {
                if (boxe[i].H > boxe[j].H &&
                        boxe[i].L > boxe[j].L &&
                        boxe[i].W > boxe[j].W) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
            i--;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        /*int[][] nums = {
                {5, 4, 3},
                {5, 4, 5},
                {6, 6, 6}
        };*/

        int[][] nums = {
                {5, 6, 3},
                {5, 4, 6},
                {6, 6, 6}
        };

        Boxes boxes = new Boxes();
        System.out.println(boxes.maxBoxes(nums));
    }
}
