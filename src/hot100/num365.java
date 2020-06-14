package hot100;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 广度优先搜索
 */
public class num365 {

    public boolean canMeasureWater(int x, int y, int z) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        Pair<Integer, Integer> p = new Pair<>(0, 0);

        // 初始化
        queue.push(p);

        int capacityA = 0, capacityB = 0;
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (!set.contains(p)) {
                if (p.getKey() + p.getValue() == z) {
                    return true;
                }
                capacityA = p.getKey();
                capacityB = p.getValue();
                // 从A容器开始转移状态
                if (capacityA < x) {
                    // 装满A
                    queue.push(new Pair<>(x, capacityB));
                }
                if (capacityA > 0) {
                    // 清空A
                    queue.push(new Pair<>(0, capacityB));
                }
                if (capacityB < y && capacityA > 0) {
                    // A倒入B
                    if (y - capacityB >= capacityA) {
                        queue.push(new Pair<>(0, capacityA + capacityB));
                    } else {
                        queue.push(new Pair<>(0, y));
                        queue.push(new Pair<>(capacityA - (y - capacityB), y));
                    }
                }

                // 从B容器开始转移状态
                if (capacityB < y) {
                    // 装满B
                    queue.push(new Pair<>(capacityA, y));
                }
                if (capacityB > 0) {
                    // 清空A
                    queue.push(new Pair<>(capacityA, 0));
                }
                if (capacityA < x && capacityB > 0) {
                    // B倒入A
                    if (x - capacityA >= capacityB) {
                        queue.push(new Pair<>(capacityA + capacityB, 0));
                    } else {
                        queue.push(new Pair<>(x, 0));
                        queue.push(new Pair<>(x, capacityB - (x - capacityA)));
                    }
                }
            }
            set.add(p);
        }
        return false;
    }
}
