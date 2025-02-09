package com.arsha.fundamentals;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please, enter words separated by space: ");
        String userInput = "apple windows oracle microsoft Apple zpple";

        List<String> words = Arrays.asList(userInput.split(" "));

        Function<List<String>, List<String>> sort = list -> {

            Integer[][] lengths = new Integer[list.size()][2];

            for (int i = 0; i < lengths.length; i++) {
                lengths[i][0] = list.get(i).length();
                lengths[i][1] = i;
            }

            System.out.println(Arrays.deepToString(lengths));
            Arrays.sort(lengths, (a, b) -> Integer.compare(b[0], a[0]));
            System.out.println(Arrays.deepToString(lengths));

            for (int i = 0; i < list.size() / 2; i++) {

                int selectedIndex = lengths[i][1];

                if (list.get(selectedIndex).equals(list.get(i))) { continue; }

                String temp = list.get(i);
                list.set( i, list.get( selectedIndex ) );
                list.set( selectedIndex, temp );

                System.out.println(temp);
            }

            return list;
        };

        System.out.println(sort.apply(words));
    }
}