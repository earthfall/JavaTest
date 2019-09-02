package com.ds;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyQueue {
    private static final int MAX_N = 100;

    private int front;
    private int rear;
    private int queue[] = new int[MAX_N];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    boolean isEmpty() {
        return (front == rear);
    }

    boolean isFull() {
        return (front + 1) % MAX_N == rear;
    }

    boolean enqueue(int value) {
        if (isFull()) {
            System.out.print("queue is full!");
            return false;
        }
        queue[front] = value;
        front++;
        if (front == MAX_N) {
            front = 0;
        }

        return true;
    }

    Integer dequeue() {
        if (isEmpty()) {
            System.out.print("queue is empty!");
            return null;
        }

        Integer value = new Integer(queue[rear]);

        rear++;
        if (rear >= MAX_N) {
            rear = 0;
        }
        return value;
    }

    public static void main(String arg[]) throws FileNotFoundException {
        System.setIn(new java.io.FileInputStream("resources/input_queue.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            MyQueue queue = new MyQueue();
            for (int i = 0; i < N; i++) {
                int value = sc.nextInt();
                queue.enqueue(value);
            }

            System.out.print("#" + test_case + " ");

            while (!queue.isEmpty()) {
                Integer value = queue.dequeue();
                if (value != null) {
                    System.out.print(value.intValue() + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
