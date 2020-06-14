package hot100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class num347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        int[] minHeap = new int[k + 1];
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext() && k > 0) {
            minHeap[k--] = it.next().getValue();
        }

        // 建立小顶堆
        buildMinHeap(minHeap);

        while (it.hasNext()) {
            int times = it.next().getValue();
            // 如果比最小值都大，就加入
            if (times > minHeap[1]) {
                minHeap[1] = times;
                adjustDown(minHeap, 1);
            }
        }

        // 将比最小值大的都放入结果中
        List<Integer> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= minHeap[1]){
                results.add(entry.getKey());
            }
        }
        return results;
    }


    private void buildMinHeap(int[] minHeap) {
        for (int i = minHeap.length / 2; i > 0; i--) {
            adjustDown(minHeap, i);
        }
    }

    private void adjustDown(int[] minHeap, int k) {
        minHeap[0] = minHeap[k];
        for (int i = 2 * k, len = minHeap.length; i < len; i = 2 * k) {
            // 建立小顶堆，寻找左右子树中的最小值
            if (i + 1 < len && minHeap[i + 1] < minHeap[i]) {i++;}
            // 如果比左右子树中最小值大，就应该开始调整
            if (minHeap[0] > minHeap[i]) {
                minHeap[k] = minHeap[i];
                k = i;
            }else {
                break;
            }
        }
        minHeap[k] = minHeap[0];
    }

    public static void main(String[] args) {
        num347 a = new num347();

        /*int[] nums = {1,1,1,2,2,3};
        List<Integer> result = a.topKFrequent(nums, 2);*/

        int[] nums = {1};
        List<Integer> result = a.topKFrequent(nums, 1);

        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }
    }
}
