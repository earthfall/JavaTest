package com.ds;

import java.util.Scanner;

public class MyMap {
    static class Node {
        int key;
        int value;

        Node left, right;

        public Node(int k, int v) {
            key = k;
            value = v;
            left = right = null;
        }
    }

    private Node current;

    MyMap() {
        current = null;
    }

    void put(int key, int value) {
        current = putRec(current, key, value);
    }

    Node putRec(Node node, int key, int value) {
        if (node == null) {
            node = new Node(key, value);
            return node;
        }

        if (key < node.key) {
            node.left = putRec(node.left, key, value);
        } else if (key > node.key) {
            node.right = putRec(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    boolean contains(int key) {
        int ret = findRec(current, key);
        if (ret != -1)
            return true;
        return false;
    }

    int get(int key) {
        return findRec(current, key);
    }

    int findRec(Node node, int key) {
        if (node != null) {
            if (key == node.key)
                return node.value;

            int ret = -1;
            ret = findRec(node.left, key);
            if (ret != -1)
                return ret;

            ret = findRec(node.right, key);
            if (ret != -1)
                return ret;
        }
        return -1;
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
        System.setIn(new java.io.FileInputStream("resources/input_map.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            MyMap map = new MyMap();

            int N = sc.nextInt();

            System.out.print("#" + test_case + " ");

            for (int i = 0; i < N; i++) {
                int cmd = sc.nextInt();
                int key = sc.nextInt();

                switch (cmd) {
                    case 1: {
                        int value = sc.nextInt();
                        map.put(key, value);
                        break;
                    }
                    case 2: {
                        map.remove(key);
                        break;
                    }
                    case 3: {
                        int ret = map.get(key);
                        System.out.print(ret + " ");
                    }
                }
            }
            System.out.println();
        }
        sc.close();
    }

}
