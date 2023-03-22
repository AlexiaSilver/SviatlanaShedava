package com.epam.javacourse.homework2;

public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int number = x;
        int rev = 0;
        int dig;

        while (x > 0) {
            dig = x % 10;
            rev = (rev * 10) + dig;
            x = x / 10;
        }
        return rev == number;
    }
}
