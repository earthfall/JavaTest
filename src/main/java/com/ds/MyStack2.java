package com.ds;

import java.util.Scanner;

import static com.ds.Resources.getResourceFile;

class MyStack2<T> {
    private static final int MAX_N = 100;

    private int top;
    private T stack[] = (T[]) new Object[MAX_N];

    MyStack2() {
        top = 0;
    }

    boolean isEmpty() {
        return (top == 0);
    }

    boolean isFull() {
        return (top == MAX_N);
    }

    boolean push(T value) {
        if (isFull()) {
            System.out.println("stack overflow!");
            return false;
        }
        stack[top] = value;
        top++;

        return true;
    }

    T pop() {
        if (top == 0) {
            System.out.println("stack is empty!");
            return null;
        }

        top--;

        return stack[top];
    }

    public static void main(String arg[]) throws Exception {
        System.setIn(new java.io.FileInputStream(getResourceFile("input_stack.txt")));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            MyStack2<Integer> stack = new MyStack2<>();
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