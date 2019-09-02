package com.ds;

import java.util.Scanner;

public class MyPriorityQueue {
    static final int MAX_SIZE = 100;

    private int heap[] = new int[MAX_SIZE];
    private int heapSize = 0;

    MyPriorityQueue() {
        heapSize = 0;
    }

    void push(int value) {
        if (heapSize + 1 > MAX_SIZE) {
            return;
        }

        heap[heapSize] = value;

        int current = heapSize;
        while (current > 0 && heap[current] < heap[(current - 1) / 2]) {
            int temp = heap[(current - 1) / 2];
            heap[(current - 1) / 2] = heap[current];
            heap[current] = temp;
            current = (current - 1) / 2;
        }

        heapSize = heapSize + 1;
    }

    int pop() {
        if (heapSize <= 0) {
            return -1;
        }

        int value = heap[0];
        heapSize = heapSize - 1;

        heap[0] = heap[heapSize];

        int current = 0;
        while (current < heapSize && current * 2 + 1 < heapSize) {
            int child;
            if (current * 2 + 2 >= heapSize) {
                child = current * 2 + 1;
            } else {
                child = heap[current * 2 + 1] < heap[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;
            }

            if (heap[current] < heap[child]) {
                break;
            }

            int temp = heap[current];
            heap[current] = heap[child];
            heap[child] = temp;

            current = child;
        }
        return value;
    }

    void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


    public static void main(String arg[]) throws Exception {
        System.setIn(new java.io.FileInputStream("resources/input_heap.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            MyPriorityQueue heap = new MyPriorityQueue();

            for (int i = 0; i < N; i++) {
                int value = sc.nextInt();
                heap.push(value);
            }

//            heap.print();
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(heap.pop() + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
