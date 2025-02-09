package com.arsha.fundamentals.functionalProgramming.functionInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        Predicate<Integer> isLegalAge = age -> age >= 18;
        System.out.println(isLegalAge.test(18));
        System.out.println(isLegalAge.test(15));

        //---------------------------

        System.out.println(isLegalAge.negate().test(15));

        //---------------------------

        Predicate<Integer> isUnderAge = Predicate.not(isLegalAge);
        System.out.println(isUnderAge.test(18));
        System.out.println(isUnderAge.test(15));

        //---------------------------

        List<String> list = Arrays.asList("A", "", "B", "");

        List<String> nonEmptyStrings = list.stream()
                .filter(Predicate.not(String::isEmpty))
                .toList(); // ["A", "B"]

        System.out.println(nonEmptyStrings);

        //---------------------------

        Predicate<String> isGreaterThanMinimumChar = username -> username.length() >= 4;
        Predicate<String> isLessThanMaximumChar    = username -> username.length() <= 10;

        final String username = "Arsha";
        System.out.println( isLessThanMaximumChar.and(isGreaterThanMinimumChar).test(username) );

        final String username2 = "TheGreatArsha";
        System.out.println( isLessThanMaximumChar.and(isGreaterThanMinimumChar).test(username2) );

        System.out.println( isLessThanMaximumChar.or(isGreaterThanMinimumChar).test(username2) );

    }
}
