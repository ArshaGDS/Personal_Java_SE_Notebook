package com.arsha.fundamentals.functionalProgramming.functionInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> println = System.out::println;
        println.accept("Hello");

        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLowerCase = s -> System.out.println(s.toLowerCase());

        Consumer<String> combinedConsumer = printUpperCase.andThen(printLowerCase);
        combinedConsumer.accept("Hello");

        //---------------------------

        System.out.println("---------------------------");

        // Custom Java consume function interface
        Consumer<List<Integer>> modify = list -> {

            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + 1);
            }
        };

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        modify.accept(list);

        // Official Java consume function interface
        list.forEach(System.out::println);

        System.out.println("---------------------------");

        list.replaceAll(x -> x * 2);
        list.forEach(System.out::println);
    }
}
