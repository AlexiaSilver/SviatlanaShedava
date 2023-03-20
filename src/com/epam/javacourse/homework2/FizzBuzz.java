package com.epam.javacourse.homework2;
/*Fizz-buzz : show ' fizz ' if a number divisible by 3,
show 'buzz' if a number divisible by 5,
show 'fizz-buzz' if a number divisible by both 3 and 5*/

public class FizzBuzz {
    public static void main(String[] args) {
        int x = 0;

        for(int i = x; i <= x; i++) {
            if (i%15 == 0)
                System.out.println("FizzBuzz");
            else if (i%5 == 0)
                System.out.println("Buzz");
            else if (i%3 == 0)
                System.out.println("Fizz");
            else System.out.println("Try another number");
        }
    }
}
