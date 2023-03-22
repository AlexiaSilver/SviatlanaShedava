package com.epam.javacourse.homework2;

public class Palindrome {
    public boolean isPalindrome(int x) {
        int number = x;
        int rev = 0;

        if (x < 0) {
            return false;
        }

        while (x > 0) {
            int dig = x % 10;
            rev = (rev * 10) + dig;
            x = x / 10;
        }
        return rev == number;
    }
}
