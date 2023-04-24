package com.epam.javacourse.homework7;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final String inputFilePath = "src/com/epam/javacourse/resources/poem.txt";
        ArrayList<String> lines = new ArrayList<>();
        // Reverse the contents of a file (1)
        try {
            FileOperations.reverseFile(inputFilePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reversing the file: " + e.getMessage());
        }

        //Sort the lines by length (2)
        try {
            List<String> sortedLines = StringOperations.sortLinesByLength(inputFilePath);
            System.out.println("Sorted lines:");
            for (String line : sortedLines) {
                if (!line.trim().isEmpty()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while sorting the lines: " + e.getMessage());
        }

        // Sort strings in an array by length (2)
        Collections.sort(lines, Comparator.comparingInt(String::length));
        // Print the sorted lines
        for (String line : lines) {
            System.out.println("Sorted line: " + line);

            // Perform set operations (3)
            Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));

            Set<Integer> unionSet = SetOperations.union(set1, set2);
            System.out.println("Union of " + set1 + " and " + set2 + " is " + unionSet);

            Set<Integer> intersectionSet = SetOperations.intersection(set1, set2);
            System.out.println("Intersection of " + set1 + " and " + set2 + " is " + intersectionSet);
        }

        // Get the unique words in a file (4)
        try {
            Set<String> uniqueWords = FileOperations.getUniqueWords(inputFilePath);
            System.out.println("Unique words in poem.txt: " + uniqueWords);
        } catch (IOException e) {
            System.out.println("An error occurred while getting unique words: " + e.getMessage());
        }

        // Get the frequency of words in a file (5)
        try {
            Map<String, Integer> wordFrequency = FileOperations.getWordFrequency(inputFilePath);
            System.out.println("Word frequency in poem.txt: " + wordFrequency);
        } catch (IOException e) {
            System.out.println("An error occurred while getting word frequency: " + e.getMessage());
        }

        // Check if parentheses in a string are balanced (6)
        String s = "("+")";
        boolean balanced = StringOperations.checkParentheses(s);
        System.out.println("Parentheses in " + s + " are " + (balanced ? "balanced" : "not balanced"));
    }
}
