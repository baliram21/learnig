package org.nayan.java8.mapVsflatMap;

import org.nayan.java8.Optional.Customer1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {


    public static List<Customer1> getAll() {
        return Stream.of(
                new Customer1(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer1(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer1(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer1(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }


}
