package com.ds;

import java.util.Scanner;

import static com.ds.Resources.getResourceFile;

public class MyListNode {
    private int data;
    private MyListNode prev;
    private MyListNode next;

    public MyListNode() {
        data = 0;
        prev = this;
        next = this;
    }

    public static MyListNode appendListNode(MyListNode head, int data) {
        MyListNode node = new MyListNode();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            MyListNode last = head.prev;
            last.next = node;
            head.prev = node;
            node.prev = last;
            node.next = head;
        }
        return head;
    }

    public static MyListNode removeListNode(MyListNode head, MyListNode node) {
        if (head == head.next) {
            return null;
        } else {
            MyListNode prevNode = node.prev;
            MyListNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            return (head == node) ? nextNode : head;
        }
    }

    public static void main(String args[]) throws Exception {
        System.setIn(new java.io.FileInputStream(getResourceFile("input_list.txt")));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            MyListNode head = null;
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                int data = sc.nextInt();
                head = MyListNode.appendListNode(head, data);
            }
            MyListNode node = head;
            while (head != head.next) {
                MyListNode nextNode = node.next;
                head = MyListNode.removeListNode(head, node);
                node = nextNode.next.next;
            }
            System.out.printf("#%d %d\n", test_case, head.data);
        }
        sc.close();
    }
}
