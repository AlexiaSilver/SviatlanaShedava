package com.epam.javacourse.homework7;

import java.io.*;
import java.util.*;

public class FileOperations {
    public static void reverseFile(String inputFilePath, String outputFilePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        Collections.reverse(lines);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
    }

    public static Set<String> getUniqueWords(String filePath) throws IOException {
        Set<String> uniqueWords = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                uniqueWords.addAll(Arrays.asList(words));
            }
        }
        return uniqueWords;
    }
    public static Map<String, Integer> getWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }
        return wordFrequency;
    }
}