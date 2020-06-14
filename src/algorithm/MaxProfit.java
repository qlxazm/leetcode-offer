package algorithm;

import recruite.Max;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yd
 * @date 2020/5/7 22:45
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] minArray = new int[len];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            minArray[i] = min;
        }

        int ans = 0;
        for(int i = 0; i < len; i++) {
            if(prices[i] > minArray[i]) {
                ans = Math.max(prices[i] - minArray[i], ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));

        List<String> list = Arrays.asList("a", "b", "c", "de");
        List<String> collect = list.stream().filter((a) -> {
            return a.length() > 1;
        }).collect(Collectors.toList());
        for (String s : collect) {
            System.out.println(s);
        }
    }

    /*
    *
    *  试卷名称：2020字节跳动校园招聘后端和客户端方向第三场考试
· 试卷有效期： (北京时间，Beijing Time)05-11 10:00:00 - 12:00:00
· 考试时长：120分钟
· 笔试链接： https://exam.nowcoder.com/cts/17065245/summary?id=D64D450CB5451526（你的专属链接，请勿转发）
    * */
}
