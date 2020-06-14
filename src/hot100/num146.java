package hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class num146 {
    class LRUCache {
        private int capacity = 0;
        private LinkedList<Integer> queue = new LinkedList<Integer>();
        private HashMap<Integer, Integer> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!queue.contains(key)) {return -1;}
            queue.remove(queue.indexOf(key));
            queue.offerFirst(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            map.put(key, value);
            if (queue.contains(key)) {
                queue.remove(queue.indexOf(key));
            }else if (queue.size() == capacity) {
                queue.pollLast();
            }
            queue.offerFirst(key);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<String>();
        //添加元素
        queue.offerFirst("a");
        queue.offerLast("b");
       /* queue.pollFirst();
        queue.pollLast();*/

       int index = queue.indexOf("b");

      /* System.out.println("b的索引是：" + index);
       queue.remove()*/

        if (queue.contains("c")){
            System.out.println("包含c");
        }
    }
}
