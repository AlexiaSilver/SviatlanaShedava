package com.epam.javacourse.homework2;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
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
