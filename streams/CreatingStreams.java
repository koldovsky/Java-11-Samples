package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class CreatingStreams {
    public static void main(String[] args) {

        // Creating from array
        // Variant 1
        String[] arr = { "program", "creek", "program", "creek", "java", "web",
                "program" };
        Stream arrStream = Stream.of(arr);

        // Variant 2
        arrStream = Arrays.stream(arr);

        // Variant 3
        arrStream = Stream.of("program", "creek", "program", "creek", "java", "web", "program");

        System.out.println("Created from array");
        arrStream.forEach(System.out::println);


        // Creating from collections
        // from collection
        List<String> list = new ArrayList<String>();
        list.add("java");
        list.add("php");
        list.add("python");
        Stream listStream = list.stream();
        System.out.println("Created from collection");
        listStream.forEach(System.out::println);



        // Using generator to create array
        // generate()
        Stream<String> stream = Stream.generate(() -> "test").limit(10);
        String[] strArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));

        // Creating counter
        IntStream.iterate(0, i -> i + 2)
                .limit(100)
                .forEach(System.out::println);

    }
}
