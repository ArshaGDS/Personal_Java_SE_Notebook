package com.arsha.fundamentals.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class DequeExamples {

    public static void main(String[] args) {

        normalDeque();
        System.out.println("================================");
        threadSafeDeque();

    }

    private static void normalDeque() {

        Deque<Integer> deque = new ArrayDeque<>(5);
        deque.add(1);
        deque.add(2);
        deque.addFirst(50);
        deque.addLast(60);

        System.out.println(deque);
    }

    private static void threadSafeDeque() {

        Deque<Integer> deque = new LinkedBlockingDeque<>(5);
        deque.add(1);
        deque.add(2);
        deque.offerFirst(50);
        deque.offerLast(60);

        System.out.println(deque);
    }
}
