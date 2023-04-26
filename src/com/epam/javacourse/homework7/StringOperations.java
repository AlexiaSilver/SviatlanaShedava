package com.epam.javacourse.homework7;

import java.io.*;
import java.util.*;

public class StringOperations {

    public static List<String> reverseLines(String inputFilePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        Collections.reverse(lines);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFilePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        return lines;
    }

    public static class StringUtils {
        public static List<String> sortLinesByLength(List<String> lines) {
            lines.sort(Comparator.comparingInt(String::length));
            return lines;
        }
    }

    public static boolean checkParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
