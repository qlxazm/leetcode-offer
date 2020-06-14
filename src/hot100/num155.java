package hot100;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/min-stack/
 */
public class num155 {
    class MinStack {
        /**
         * 尾部作为栈顶
         */
        private ArrayList<Integer> stack = new ArrayList<>();
        private ArrayList<Integer> list = new ArrayList<>();
        private int size = 0;

        public MinStack() { }

        public void push(int x) {
            stack.add(x);
            size++;
            // 维护有序链表
            int i = 0, len = list.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            for (; i < len; i++) {
                if (list.get(i) >= x) {
                    break;
                }else {
                    tempList.add(list.get(i));
                }
            }
            tempList.add(x);
            for (; i < len; i++) {tempList.add(list.get(i));}
            list = tempList;
        }

        public void pop() {
            if (size > 0) {
                int temp = stack.remove(size - 1);
                size--;
                // 维护有序链表
                int i = 0, len = list.size();
                ArrayList<Integer> tempList = new ArrayList<>();
                for (; i < len; i++) {
                    if (list.get(i) == temp) {
                        break;
                    }else {
                        tempList.add(list.get(i));
                    }
                }
                for (i++; i < len; i++) {tempList.add(list.get(i));}
                list = tempList;
            }
        }

        public int top() {
            return stack.get(size - 1);
        }

        public int getMin() {
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int b = list.remove(1);
        System.out.print("移除的元数是：" + b);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }

    }
}
