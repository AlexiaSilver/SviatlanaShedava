package com.epam.javacourse.homework2;

public class Fibonacci {
    public void getFibonacciRow(int n) {
        int first = 0;
        int second = 1;
        System.out.println("Fibonacci Series:");

        for (int i = 1; i <= n; ++i) {
            System.out.printf(first + " ");

            int next = first + second;
            first = second;
            second = next;

        }
    }
}
