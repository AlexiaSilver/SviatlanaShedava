package com.epam.javacourse.homework2;

public class LastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        String x = s.trim();

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                length = 0;
            else
                length++;
        }
        return length;
    }
}
