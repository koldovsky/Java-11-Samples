package streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamCollections {

    private static List<String> persons = new ArrayList<>();
    static {
        persons.add("Stephen");
        persons.add("Regina");
        persons.add("Stanton");
        persons.add("Roger");
        persons.add("Carmen");
        persons.add("Morris");
    }

    public static void main(String[] args) {
        System.out.println("1. All the persons in the List:");
        persons.forEach(System.out::println);

        System.out.println("2. All the persons sorted:");
        persons.stream().sorted().forEach(System.out::println);

        System.out.println("3. Showing source list again:");
        persons.forEach(System.out::println);

        Stream<String> selectedPerson = getPersons(p -> p.startsWith("R"));
        System.out.println("4. Hints on starts with R:");
        selectedPerson.forEach(p -> System.out.println(p));

        Stream<String> selectedUpperCasePersons = getPersons(p -> p.endsWith("n")).map(String::toUpperCase);
        System.out.println("5. Persons that end with n in upper case");
        selectedUpperCasePersons.forEach(System.out::println);

        Optional<String> allPersons = persons.stream().reduce( (key1, key2) -> key1.concat(":").concat(key2) );
        System.out.println("6. All persons concatenated: " + allPersons.get());

    }

    static Stream<String> getPersons(Predicate<String> predicate) {
        return persons.stream().filter(predicate);
    }

}
