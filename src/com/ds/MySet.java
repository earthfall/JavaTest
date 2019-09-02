package com.ds;

import java.util.Scanner;

public class MySet {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    private Node current;

    MySet() {
        current = null;
    }

    void add(int key) {
        current = addRec(current, key);
    }

    Node addRec(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }

        if (key < node.key) {
            node.left = addRec(node.left, key);
        } else if (key > node.key) {
            node.right = addRec(node.right, key);
        }

        return node;
    }

    boolean contains(int key) {
        return findRec(current, key);
    }

    boolean findRec(Node node, int key) {
        if (node != null) {
            if (key == node.key)
                return true;
            if (findRec(node.left, key))
                return true;
            if (findRec(node.right, key))
                return true;
        }
        return false;
    }

    void printAll() {
        printAll(current);
    }

    void printAll(Node node) {
        if (node != null) {
            printAll(node.left);
            System.out.print(node.key + " ");
            printAll(node.right);
        }
    }

    void remove(int key) {
        current = removeRec(current, key);
    }

    Node removeRec(Node node, int key) {
        if (node == null)
            return node;

        if (key < node.key) {
            node.left = removeRec(node.left, key);
        } else if (key > node.key) {
            node.right = removeRec(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.key = minValue(node.right);
            node.right = removeRec(node.right, node.key);
        }

        return node;
    }

    int minValue(Node node) {
        int minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }

    public static void main(String arg[]) throws Exception {
        System.setIn(new java.io.FileInputStream("resources/input_set.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            MySet set = new MySet();

            int N = sc.nextInt();

            System.out.print("#" + test_case + " ");

            for (int i = 0; i < N; i++) {
                int cmd = sc.nextInt();
                int key = sc.nextInt();

                switch (cmd) {
                    case 1: {
                        set.add(key);
                        break;
                    }
                    case 2: {
                        set.remove(key);
                        break;
                    }
                }
            }
            set.printAll();

        }
        sc.close();
    }

}
