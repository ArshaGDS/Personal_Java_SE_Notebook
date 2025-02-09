package com.arsha.fundamentals.collections;

import java.util.HashMap;
import java.util.Set;

public class MapExamples {

    public static void main(String[] args) {

        HashMap2();
    }

    private static void HashMap() {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println("Print keys: " + map.keySet());
        System.out.println("Print values: " + map.values());
        System.out.println("Print entries: " + map.entrySet());
        System.out.println("Print map: " + map);
    }

    private static void HashMap2() {

        HashMap<Integer, UserAccount> map = new HashMap<>();
        map.put(1, new UserAccount("Arsha", 18));
        map.put(2, new UserAccount("Arsha", 18));

        System.out.println(map);
    }

    static class UserAccount {

        String name;
        int age;

        UserAccount(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "UserAccount{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
