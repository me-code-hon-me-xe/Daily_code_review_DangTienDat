package Day7_7_2023.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        // Create and array
        String[] fruit = {"apple", "banana", "orange"};

        // Create an empty String to avoid returning null for streams with no element
        Stream<String> emptyString = Stream.empty();

        // We can also create a stream of any type of Collection (Collection, List, Set):
        Collection<String> collection = Arrays.asList(fruit);  //
        Stream<String> streamfColletion = collection.stream();

        // Stream of Array
        Stream<String> streamOfArrayFull = Arrays.stream(fruit);
        Stream<String> streamOfArrayPart = Arrays.stream(fruit, 1, 3);

        // Create a Stream directly from the sequence of elements
        Stream<String> streamDirectly = Stream.of("apple", "banana", "orange");
//        streamDirectly.forEach(System.out :: println);

        // Stream Builder
        Stream.Builder<String> streamBuilder = Stream.builder();

        streamBuilder.add("apple")
                .add("banana")
                .add("orange");

        Stream<String> stream = streamBuilder.build();
//        stream.forEach(System.out :: println);

        // Stream intermediate operation
        // filter(Predicate<T> predicate)
        Integer [] numbers = {1,2,3,4,5,6};
        Stream<Integer> streamNumbers = Arrays.stream(numbers);
        List<Integer> evenNumbers = streamNumbers.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).collect(Collectors.toList()); // Collect the filtered elements into a new list
        evenNumbers.forEach(System.out::println);
    }

    public Stream<String> streamOf(List<String> list) {
        // This is normal way of if condtition
        if (list == null || list.isEmpty()) {
            return Stream.empty();
        }
        return list.stream();
        // Or you can use lambda expression to tidy your code
        // return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }
}

