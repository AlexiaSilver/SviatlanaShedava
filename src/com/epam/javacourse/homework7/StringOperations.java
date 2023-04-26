package com.epam.javacourse.homework7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringOperations {
    public static List<String> sortLinesByLength(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines()
                    .sorted(Comparator.comparingInt(String::length))
                    .collect(Collectors.toList());
        }
    }

    public static boolean checkParentheses(String s) {
        int count = s.chars()
                .filter(c -> c == '(')
                .map(c -> 1)
                .sum() - s.chars()
                .filter(c -> c == ')')
                .map(c -> 1)
                .sum();
        return count == 0;
    }
}
