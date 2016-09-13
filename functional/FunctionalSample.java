package functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalSample {

    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 3;

        System.out.println(predicate.test("foo"));
        System.out.println(predicate.test("check this"));

        Predicate<String> isEmpty = String :: isEmpty;
        System.out.println(isEmpty.test(""));
        System.out.println(isEmpty.test("foo"));


        Function<String, Integer> toInteger =
                Integer :: valueOf;
        Function<String, String> backToString =
                toInteger.andThen(String :: valueOf);
        System.out.println(backToString.apply("123"));


    }



}
