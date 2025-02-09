package com.arsha.fundamentals.collections.iterators;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class IteratorExamples {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator = list.iterator();

        System.out.println(iterator.next());
        iterator.remove();
        // iterator.remove(); // Runtime exception
        System.out.println(list);

        /* ConcurrentModificationException
        list.remove(2);
        iterator.next();
        System.out.println(list);
        */

        //===================================

        LinkedList<Integer> linkedList = new LinkedList<>(list);
        Iterator<Integer> reverseIterator = linkedList.descendingIterator();

        while (reverseIterator.hasNext()) {
            System.out.println("Reverse list: " + reverseIterator.next());
        }

        //===================================

        /**
         * Thread safe hastesh, vali age list to taghtir bedim, iterator az taghir bakhabr nemishe
         * */

        List<Integer> threadSafeList = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator2 = threadSafeList.iterator();

        threadSafeList.set(0, 100);

        System.out.println(iterator2.next());

        //===================================

        /**
         * Thread safe hastesh va ba taghire list, iterator ham update mishe
         * */

        Collection<Integer> collection = new ConcurrentLinkedDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator3 = collection.iterator();

        collection.add(20);

        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + "\t");
        }
        System.out.println();

        //===================================

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ListIterator<Integer> listIterator = list2.listIterator(2);

        System.out.println("list iterator position: " + listIterator.previous());

        listIterator.set(10);
        System.out.println("all list: " + list2);

        listIterator.add(50);
        System.out.println("all list: " + list2);

        listIterator.next();
        listIterator.remove();
        System.out.println("all list: " + list2);
    }
}
