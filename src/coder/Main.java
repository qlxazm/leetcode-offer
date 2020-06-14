package coder;

import java.util.Scanner;

public class Main {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    public void input() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        Node head = null, tail = null, p = null;
        int i = 0, n;
        while (i < a) {
            p = new Node(in.nextInt());
            if (head == null && tail == null) {
                head = tail = p;
            } else {
                tail.next = p;
                tail = p;
            }
            i++;
        }
        // 形成唤醒链表
        tail.next = head;

        int num = in.nextInt();
        p = head;
        while (p != tail && p.next.val <= num) {
            p = p.next;
        }

        if (p.next.val > num) {
            Node q = p.next;
            p.next = new Node(num);
            p.next.next = q;
        }
        if (p == tail) {
            Node q = p.next;
            p.next = new Node(num);
            p.next.next = head;
        }

        // 输出内容
        i = 0;
        p = head;
        while (i <= a) {
            System.out.println(p.val);
            p = p.next;
            i++;
        }
    }


    public static void main(String[] args) {

        Main a = new Main();
        a.input();
    }
}
