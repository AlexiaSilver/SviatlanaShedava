package com.epam.javacourse.homework7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FileOperations {
    public static void reverseFile(String inputFilePath) throws IOException {
        List<String> lines;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            lines = br.lines().collect(Collectors.toList());
        }
        Collections.reverse(lines);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFilePath))) {
            lines.forEach(line -> {
                try {
                    bw.write(line);
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public static Set<String> getUniqueWords(String filePath) throws IOException {
        Set<String> uniqueWords;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            uniqueWords = br.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.toSet());
        }
        return uniqueWords;
    }

    public static Map<String, Integer> getWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFrequency;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            wordFrequency = br.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
        }
        return wordFrequency;
    }
}
