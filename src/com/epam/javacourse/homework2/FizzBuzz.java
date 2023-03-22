package com.epam.javacourse.homework2;

import java.util.Scanner;

public class FizzBuzz {
    public void fizzBuzz() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the number: ");
        while (sc.hasNext()) {
            int x = sc.nextInt();
            if (x % 15 == 0)
                System.out.println("FizzBuzz");
            else if (x % 5 == 0)
                System.out.println("Buzz");
            else if (x % 3 == 0)
                System.out.println("Fizz");
            else {
                System.out.println("Stop");
                break;
            }
        }
        sc.close();
    }
}

