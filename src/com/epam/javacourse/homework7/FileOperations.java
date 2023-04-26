package com.epam.javacourse.homework7;

import java.io.*;
import java.util.*;

public class FileOperations {
    public static List<String> reverseFileWithStreams(String inputFilePath) throws IOException {
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

    public static int getCountOfWord(String filePath, String word) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equals(word)) {
                        count++;
                    }
                }
            }
        }
        return count;
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
