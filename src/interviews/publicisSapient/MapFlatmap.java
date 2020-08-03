package interviews.publicisSapient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFlatmap {

    public static void main(String[] args) {
        List<String> numbers= Arrays.asList("2","5","55","65","56","10");
        System.out.println("Original List: "+numbers);
        List<Integer> even = numbers.stream()
                                    .map(s -> Integer.valueOf(s))
                                    .filter(number -> number % 2 == 0)
                                    .collect(Collectors.toList());

        System.out.println("Processed List: "+even);

        List evens = Arrays.asList(2, 4, 6);
        List odds = Arrays.asList(3, 5, 7);
        List primes = Arrays.asList(2, 3, 5, 7, 11);

        List num = (List) Stream.of(evens, odds, primes).flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("flattend list: " + num);

    }
}
