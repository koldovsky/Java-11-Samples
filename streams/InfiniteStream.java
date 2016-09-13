package streams;

import java.util.stream.Stream;

public class InfiniteStream {

    public static void main(String[] args) {

        Stream<Integer> infinite = Stream.iterate(100, x -> x + 1);

        //  To iterate over infinite stream we need to set limit
        infinite.limit(100).forEach(System.out::println);
        // !!!! Trying to access stream again causes exception
        infinite.limit(200).forEach(System.out::println);


        // This shows iterating over stream in not very elegant way, just for demo
        try {
            infinite.forEach(val -> {
                System.out.println(val);
                if (val > 10000) {
                    throw new RuntimeException("Need to stop");
                }
            });
        } catch (RuntimeException e) {
            // do nothing, just a sample
        }




    }

}
