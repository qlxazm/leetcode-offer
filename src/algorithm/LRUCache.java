package algorithm;


import java.util.HashMap;

/**
 */
public class LRUCache {

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList{
        Node head;
        Node tail;

        public DoubleList() {
            head = tail = new Node(-1, -1);
        }

        /**
         * 移除节点
         * @param node
         */
        public Node remove(Node node) {
            // 如果移除的是尾节点
            if (node == tail) {
                tail = tail.pre;
                tail.next = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = node.next = null;
            return node;
        }

        /**
         * 头插法插入一个节点
         * @param node
         */
        public void addFirst(Node node) {
            if (head == tail) {
                head.next = node;
                node.pre = head;
                tail = node;
            } else {
                node.next = head.next;
                head.next.pre = node;

                head.next = node;
                node.pre = head;
            }
        }

        /**
         * 删除最后一个
         * @return
         */
        public Node removeLast() {
            return head == tail ? null : remove(tail);
        }

    }

    private int capacity;
    private int size;
    private DoubleList list;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // 如果已经存在
        if (node != null) {
            node.val = value;
            list.remove(node);
            list.addFirst(node);
            return;
        }
        // 达到最大容量
        if (size == capacity) {
            node = list.removeLast();
            map.remove(node.key);
            size--;
        }

        node = new Node(key, value);
        list.addFirst(node);
        map.put(key, node);
        size++;
    }
}
