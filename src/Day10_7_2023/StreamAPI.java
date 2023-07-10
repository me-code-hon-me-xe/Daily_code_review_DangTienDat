package Day10_7_2023;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        // Create an array of String object
        String[] fruit = {"apple", "banana", "orange"};
        // Stream directly from the array using Stream.of();
        Stream<String> streamDirectly = Stream.of(fruit[0], fruit[1], fruit[2]);
        List<String> newMap = streamDirectly.map(fruits -> "Here is " + fruits).collect(Collectors.toList());
        List<String> newMap2 = streamDirectly.filter(fruits -> fruits.equals("banana")).collect(Collectors.toList());

        newMap.forEach(System.out::println);
        System.out.println(newMap2);

    }
}
