package com.epam.javacourse.homework7;

import java.util.ArrayList;
import java.util.List;

public class DivisibleBy31Example {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(31, 62, 155, 115);

        DivisibleBy31 divisibleBy31 = num -> num % 31 == 0;
        for (int num : numbers) {
            System.out.println(num + " is divisible by 31: " + divisibleBy31.isDivisible(num));
        }

        List<Integer> divisibleNumbers = filter(numbers, divisibleBy31);
        System.out.println("Numbers divisible by 31: " + divisibleNumbers);
    }

    public static List<Integer> filter(List<Integer> numbers, DivisibleBy31 predicate) {
        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (predicate.isDivisible(num)) {
                result.add(num);
            }
        }
        return result;
    }
}
