package com.ds;

import java.util.Scanner;

import static com.ds.Resources.getResourceFile;

public class MyPriorityQueue2<T> {
    static final int MAX_SIZE = 100;

    interface ValueComparator<T> {
        boolean compare(T arg1, T arg2);
    }

    private T heap[] = (T[]) new Object[MAX_SIZE];
    private int heapSize = 0;
    private ValueComparator<T> comparator;

    MyPriorityQueue2(ValueComparator<T> comparator) {
        heapSize = 0;
        this.comparator = comparator;
    }

    void push(T value) {
        if (heapSize + 1 > MAX_SIZE) {
            return;
        }

        heap[heapSize] = value;

        int current = heapSize;
        while (current > 0 && comparator.compare(heap[current], heap[(current - 1) / 2])) {
            T temp = heap[(current - 1) / 2];
            heap[(current - 1) / 2] = heap[current];
            heap[current] = temp;
            current = (current - 1) / 2;
        }

        heapSize = heapSize + 1;
    }

    T pop() {
        if (heapSize <= 0) {
            return null;
        }

        T value = heap[0];
        heapSize = heapSize - 1;

        heap[0] = heap[heapSize];

        int current = 0;
        while (current < heapSize && current * 2 + 1 < heapSize) {
            int child;
            if (current * 2 + 2 >= heapSize) {
                child = current * 2 + 1;
            } else {
                child = comparator.compare(heap[current * 2 + 1], heap[current * 2 + 2]) ? current * 2 + 1 : current * 2 + 2;
            }

            if (comparator.compare(heap[current], heap[child])) {
                break;
            }

            T temp = heap[current];
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
        System.setIn(new java.io.FileInputStream(getResourceFile("input_heap.txt")));
        Scanner sc = new Scanner(System.in);

        ValueComparator<Integer> cmp = (arg1, arg2) -> arg1 < arg2;

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            MyPriorityQueue2<Integer> heap = new MyPriorityQueue2<>(cmp);

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
