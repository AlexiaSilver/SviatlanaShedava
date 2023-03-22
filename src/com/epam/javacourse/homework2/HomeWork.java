package com.epam.javacourse.homework2;

import java.util.Arrays;

public class HomeWork {
    public static void main(String[] args) {
        //Fibonacci
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.getFibonacciRow(10);
        System.out.println();

        //Palindrome
        Palindrome palindrome = new Palindrome();
        System.out.println("Is Palindrome: " + palindrome.isPalindrome(121));

        //Sqrt
        Sqrt sqrt = new Sqrt();
        System.out.println("Square root: " + sqrt.mySqrt(4));

        //TwoSums
        TwoSums twosums = new TwoSums();
        System.out.println("Indices: " + Arrays.toString(twosums.twoSum(new int[]{2, 7, 11, 15}, 9)));

        //LastWord
        LastWord lastWord = new LastWord();
        System.out.println("Last word length: " + lastWord.lengthOfLastWord("   fly me   to   the moon  "));

        //FizzBuzz
        FizzBuzz fizzbuzz = new FizzBuzz();
        fizzbuzz.fizzBuzz();
    }
}
