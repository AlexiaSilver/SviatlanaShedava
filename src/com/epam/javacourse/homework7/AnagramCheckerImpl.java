package com.epam.javacourse.homework7;

import java.util.Arrays;

public class AnagramCheckerImpl implements AnagramChecker {
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] s1Chars = s1.toLowerCase().toCharArray();
        char[] s2Chars = s2.toLowerCase().toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);
    }
}
