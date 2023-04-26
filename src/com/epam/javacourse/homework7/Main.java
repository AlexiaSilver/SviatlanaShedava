package com.epam.javacourse.homework7;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "src/com/epam/javacourse/resources/poem.txt";

        // Check if two strings are anagrams
        String s1 = "dusty";
        String s2 = "study";
        AnagramChecker checker = new AnagramCheckerImpl();
        System.out.println("1. " + s1 + " and " + s2 + " are " + (checker.isAnagram(s1, s2) ? "" : "not ") + "anagrams.");

        // Check MathOperations
        MathOperationsImpl mathOperations = new MathOperationsImpl();

        int a = 5;
        int b = 10;
        int result = mathOperations.sum(a, b);
        System.out.println("2. " + "The sum of " + a + " and " + b + " is " + result);

        // Reverse the order of lines in a file (1)
        try {
            List<String> reversedLines = StringOperations.reverseLines(inputFilePath);
            System.out.println("3. " + "Reversed lines:");
            reversedLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("An error occurred while reversing the file: " + e.getMessage());
        }

        // Sort lines by length (2)
        List<String> sortedLines = StringOperations.StringUtils.sortLinesByLength(Collections.singletonList(inputFilePath));
        System.out.println("4. " + "Sorted lines:");
        for (String line : sortedLines) {
            if (!line.trim().isEmpty()) {
                System.out.println(line);
            }
        }

        // Perform set operations (3)
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));

        Set<Integer> unionSet = SetOperations.union(set1, set2);
        System.out.println("5. " + "Union of " + set1 + " and " + set2 + " is " + unionSet);

        Set<Integer> intersectionSet = SetOperations.intersection(set1, set2);
        System.out.println("6. " + "Intersection of " + set1 + " and " + set2 + " is " + intersectionSet);

        // Get the unique words in a file (4)
        try {
            Set<String> uniqueWords = FileOperations.getUniqueWords(inputFilePath);
            System.out.println("7. " + "Unique words in poem.txt: " + uniqueWords);
        } catch (IOException e) {
            System.out.println("An error occurred while getting unique words: " + e.getMessage());
        }

        // Get the frequency of words in a file (5)
        try {
            Map<String, Integer> wordFrequency = FileOperations.getWordFrequency(inputFilePath);
            System.out.println("8. " + "Word frequency in poem.txt: " + wordFrequency);
        } catch (IOException e) {
            System.out.println("An error occurred while getting word frequency: " + e.getMessage());
        }

        // Check if parentheses in a string are balanced (6)
        String s = "(" + ")";
        boolean balanced = StringOperations.checkParentheses(s);
        System.out.println("9. " + "Parentheses in " + s + " are " + (balanced ? "balanced" : "not balanced"));
    }
}
