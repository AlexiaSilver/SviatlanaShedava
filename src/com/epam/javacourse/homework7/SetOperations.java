package com.epam.javacourse.homework7;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        return Stream.concat(set1.stream(), set2.stream())
                .collect(Collectors.toSet());
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        return set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
    }
}
