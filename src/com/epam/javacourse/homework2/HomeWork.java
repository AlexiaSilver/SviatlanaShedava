package com.epam.javacourse.homework2;

import java.util.Arrays;

public class HomeWork {

    public static void main(String[] args) {
        // Fibonacci
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.getFibonacciRow(10);

        //Palindrome
        Palindrome palindrome = new Palindrome();
        System.out.println("\nIs 121 Palindrome: " + palindrome.isPalindrome(121));

        //Sqrt
        Sqrt sqrt = new Sqrt();
        final int mySqrt = sqrt.mySqrt(4);
        System.out.println(mySqrt);

        //TwoSums
        TwoSums twosums = new TwoSums();
        final int[] twoSum = twosums.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(twoSum));

        //LastWord
        LastWord lastWord = new LastWord();
        int lengthOfLastWord = lastWord.lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(lengthOfLastWord);

        //FizzBuzz
        FizzBuzz fizzbuzz = new FizzBuzz();
        fizzbuzz.fizzBuzz();
    }
}
