package com.ds;

import java.io.FileNotFoundException;
import java.util.Scanner;

class MyStack {
    private static final int MAX_N = 100;

    private int top;
    private int stack[] = new int[MAX_N];

    MyStack() {
        top = 0;
    }

    boolean isEmpty() {
        return (top == 0);
    }

    boolean isFull() {
        return (top == MAX_N);
    }

    boolean push(int value) {
        if (isFull()) {
            System.out.println("stack overflow!");
            return false;
        }
        stack[top] = value;
        top++;

        return true;
    }

    Integer pop() {
        if (top == 0) {
            System.out.println("stack is empty!");
            return null;
        }

        top--;

        return new Integer(stack[top]);
    }

    public static void main(String arg[]) throws FileNotFoundException {
        System.setIn(new java.io.FileInputStream("resources/input_stack.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            MyStack stack = new MyStack();
            for (int i = 0; i < N; i++) {
                int value = sc.nextInt();
                stack.push(value);
            }

            System.out.print("#" + test_case + " ");

            while (!stack.isEmpty()) {
                Integer value = stack.pop();
                if (value != null) {
                    System.out.print(value.intValue() + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}