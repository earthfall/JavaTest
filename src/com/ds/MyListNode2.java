package com.ds;

import java.util.Scanner;

public class MyListNode2<T> {
    private T data;
    private MyListNode2<T> prev;
    private MyListNode2<T> next;

    public MyListNode2(T data) {
        this.data = data;
        prev = this;
        next = this;
    }

    public static <T> MyListNode2<T> appendListNode(MyListNode2<T> head, T data) {
        MyListNode2<T> node = new MyListNode2<>(data);
        if (head == null) {
            head = node;
        } else {
            MyListNode2<T> last = head.prev;
            last.next = node;
            head.prev = node;
            node.prev = last;
            node.next = head;
        }
        return head;
    }

    public static <T> MyListNode2<T> removeListNode(MyListNode2<T> head, MyListNode2<T> node) {
        if (head == head.next) {
            return null;
        } else {
            MyListNode2<T> prevNode = node.prev;
            MyListNode2<T> nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            return (head == node) ? nextNode : head;
        }
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new java.io.FileInputStream("resources/input_list.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            MyListNode2<Integer> head = null;
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                int data = sc.nextInt();
                head = MyListNode2.appendListNode(head, data);
            }
            MyListNode2<Integer> node = head;
            while (head != head.next) {
                MyListNode2<Integer> nextNode = node.next;
                head = MyListNode2.removeListNode(head, node);
                node = nextNode.next.next;
            }
            System.out.printf("#%d %d\n", test_case, head.data);
        }
        sc.close();
    }
}
