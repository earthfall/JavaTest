package com.ds;

import java.util.Scanner;

public class MySet2<T> {
    interface ValueComparator<T> {
        boolean compare(T arg1, T arg2);
    }

    static class Node<T> {
        T key;
        Node<T> left, right;

        public Node(T item) {
            key = item;
            left = right = null;
        }
    }

    private ValueComparator<T> comparator;
    private Node<T> current;

    MySet2(ValueComparator<T> comparator) {
        current = null;
        this.comparator = comparator;
    }

    void add(T key) {
        current = addRec(current, key);
    }

    private Node<T> addRec(Node<T> node, T key) {
        if (node == null) {
            node = new Node<T>(key);
            return node;
        }

        if (comparator.compare(key, node.key)) {
            node.left = addRec(node.left, key);
        } else if (comparator.compare(node.key, key)) {
            node.right = addRec(node.right, key);
        }

        return node;
    }

    boolean contains(T key) {
        return findRec(current, key);
    }

    private boolean findRec(Node<T> node, T key) {
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

    void printAll(Node<T> node) {
        if (node != null) {
            printAll(node.left);
            System.out.print(node.key + " ");
            printAll(node.right);
        }
    }

    void remove(T key) {
        current = removeRec(current, key);
    }

    private Node<T> removeRec(Node<T> node, T key) {
        if (node == null)
            return node;

        if (comparator.compare(key, node.key)) {
            node.left = removeRec(node.left, key);
        } else if (comparator.compare(node.key, key)) {
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

    T minValue(Node<T> node) {
        T minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }

    public static void main(String[] arg) throws Exception {
        System.setIn(new java.io.FileInputStream("resources/input_set.txt"));
        Scanner sc = new Scanner(System.in);

        ValueComparator<Integer> cmp = (arg1, arg2) -> arg1 < arg2;

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            MySet2<Integer> set = new MySet2<>(cmp);

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
