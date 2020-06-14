package algorithm;

import java.util.HashMap;

/**
 * @author qlx
 * @date 2020/6/2 17:15
 */
public class LFUCache {

    /**
     * 双向链表节点
     */
    class Node{
        int key;
        int val;
        /**
         * 访问计数
         */
        int count;

        Node pre;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }

    /**
     * 带有头结点head和尾节点tail的双向链表
     */
    class DoubleList{
        Node head;
        Node tail;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(1, 1);
            head.next = tail;
            tail.pre = head;
        }

        /**
         * 头插法插入节点
         * @param node
         */
        public void addFirst(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        /**
         * 删除一个节点
         * @param node
         * @return
         */
        public Node remove(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = node.next = null;
            return node;
        }

        public Node removeLast() {
            return remove(tail.pre);
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }


    private int capacity;
    /**
     * 记录当前的大小
     */
    private int size;

    /**
     * 用于实现key到Node的映射
     */
    private HashMap<Integer, Node> map;

    /**
     * key是访问的次数
     * value是同样访问次数的链表
     */
    private HashMap<Integer, DoubleList> visitToList;

    /**
     * 最少访问次数
     */
    private int minVisit = Integer.MAX_VALUE;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        visitToList = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (capacity != 0 && node != null) {
            // 将Node从visitToList相应的链表上摘下来
            removeNode(node);
            // 访问计较数加一并插入到新的list中
            node.count++;
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // 原来就有
        if (node != null) {
            // 将Node从visitToList相应的链表上摘下来
            removeNode(node);

            // 访问次数加一并插入到新的list中
            node.count++;
            node.val = value;

            addNode(node);
            return;
        }

        // 超过了容量
        if (size == capacity) {
            if ((node = removeMin()) != null) {
                map.remove(node.key);
                size--;
            }
        }
        node = new Node(key, value);
        addNode(node);
        map.put(key, node);
        minVisit = 1;
        size++;
    }

    public Node removeMin() {
        DoubleList list = visitToList.get(minVisit);
        if (list != null) {
            return list.removeLast();
        }
        return null;
    }

    private Node removeNode(Node node) {
        DoubleList list = visitToList.get(node.count);
        if (list != null) {
            list.remove(node);
        }
        // 移除一个元素后检查是否需要更新minVisit，这个是关键
        if (minVisit > 0 && (list = visitToList.get(minVisit)) != null && list.isEmpty()) {
            minVisit++;
        }
        return node;
    }

    private void addNode(Node node) {
        DoubleList list = visitToList.get(node.count);
        if (list == null) {
            list = new DoubleList();
            visitToList.put(node.count, list);
        }
        list.addFirst(node);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
