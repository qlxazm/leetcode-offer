package hot100;

public class num42 {
    public int trap(int[] height){
        int result = 0, pillsCount = 0, maxAccount, i = 0, len = height.length;

        //找到第一个非0
        while (i < len && height[i++] == 0);
        i--;

        while (i < len - 1) {
            // 固定住一个柱子
            int max = i + 1, j = i + 1;
            pillsCount = maxAccount = 0;
            // 寻找下一个大于等于固定柱子的柱子，如果不存在这样的柱子，就找固定柱子后面的最长的一个（这时说明已经是最后一轮计算）
            while (j < len){
                pillsCount += height[j];
                if (height[j] >= height[max]) {
                    maxAccount = pillsCount;
                    max = j;
                }
                if (height[j] >= height[i]){break;}
                j++;
            }
            result += Math.min(height[i], height[max]) * (max - i - 1) - maxAccount + height[max];
            i = max;
        }


        return result;
    }


  /*  public int trap(int[] height) {
        int result = 0, len = height.length;
        int i;
        // 结束标志，如果这一趟遍历发现高度大于0的柱子小于等于1个，就结束
        int count;
        do {
            count = 0;
            // 找到第一个不为0的
            for (i = 0; i < len && height[i] <= 0; i++);
            while (i < len) {
                // 找到右侧第一个可以放水的空穴
                do {
                    count++;
                    height[i]--;
                    i++;
                }while (i < len && height[i] > 0);
                //向后探测，是否可以加上temp中保存的水量
                int temp = 0;
                while (i < len && height[i] <= 0) {
                    temp++;
                    i++;
                }
                if (i < len){result += temp;}
            }
        }while (count > 1);

        return result;
    }*/

    public static void main(String[] args) {
        num42 a = new num42();
//        int[] numns = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] numns = {5,2,1,2,1,5};
        System.out.println(a.trap(numns));
    }
}
