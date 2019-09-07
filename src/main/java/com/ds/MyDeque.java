package com.ds;

import java.util.Scanner;

import static com.ds.Resources.getResourceFile;

public class MyDeque {
    private static final int MAX = 100;

    private int arr[];
    private int front;
    private int rear;
    private int size;

    MyDeque(int size) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    void insertFront(int value) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }
        arr[front] = value;
    }

    void insertRear(int value) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        arr[rear] = value;
    }

    int getFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[front];
    }

    int getRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Underflow");
            return -1;
        }
        return arr[rear];
    }

    void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
    }

    void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow");
            return;
        }

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
    }

    public static void main(String arg[]) throws Exception {
        System.setIn(new java.io.FileInputStream(getResourceFile("input_deque.txt")));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            MyDeque myDeque = new MyDeque(N);

            System.out.print("#" + test_case + " ");

            for (int i = 0; i < M; i++) {
                int cmd = sc.nextInt();

                switch (cmd) {
                    case 1: {
                        int elem = sc.nextInt();
                        myDeque.insertFront(elem);
                        break;
                    }
                    case 2: {
                        int elem = sc.nextInt();
                        myDeque.insertRear(elem);
                        break;
                    }
                    case 3: {
                        System.out.print(myDeque.getFront() + " ");
                        break;
                    }
                    case 4: {
                        System.out.print(myDeque.getRear() + " ");
                        break;
                    }
                    case 5: {
                        myDeque.deleteFront();
                        break;
                    }
                    case 6: {
                        myDeque.deleteRear();
                        break;
                    }
                }
            }

            System.out.println();

        }
        sc.close();
    }
}
