package com.arsha.fundamentals.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionExamples {

    void arrayList() {

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,3,4));
    }

    void vector() {

        Vector<String> list = new Vector<>();
        list.add("A");
        list.add("B");
        list.add("C");
    }

    void stack() {

        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
    }

    void linkedList() {

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
    }

    void copyOnWriteArrayList() {

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
    }

    public void reverseSort() {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10,5,2,15,1,3,18));
        System.out.println(list);

        // Normal order sort
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        // Reverse sort
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
