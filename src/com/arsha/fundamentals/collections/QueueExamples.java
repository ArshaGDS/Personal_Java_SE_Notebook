package com.arsha.fundamentals.collections;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueExamples {

    public static void main(String[] args) {

        normalQueue();
        System.out.println("================================");
        priorityQueue();
        System.out.println("================================");
        threadSafeQueue();
        System.out.println("================================");
        threadSafePriorityQueue();
    }

    private static void normalQueue() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(15);
        queue.add(5);
        queue.add(25);
        queue.add(1);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Size after Peek: " + queue.size());

        System.out.println("poll: " + queue.poll());
        System.out.println("Size after Pop: " + queue.size());

        System.out.println(queue);
    }

    @SuppressWarnings("DuplicatedCode")
    private static void priorityQueue() {

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(15);
        queue.add(5);
        queue.add(25);
        queue.add(1);

        System.out.println(queue);
    }

    @SuppressWarnings("DuplicatedCode")
    private static void threadSafeQueue() {

        Queue<Integer> queue = new ArrayBlockingQueue<>(5);
        queue.offer(10);
        queue.offer(15);
        queue.offer(5);
        queue.offer(25);
        queue.offer(1);
        queue.offer(8);
        queue.offer(90);

        System.out.println(queue);
    }

    @SuppressWarnings("DuplicatedCode")
    private static void threadSafePriorityQueue() {

        Queue<Integer> queue = new PriorityBlockingQueue<>(5);
        queue.offer(10);
        queue.offer(15);
        queue.offer(5);
        queue.offer(25);
        queue.offer(1);
        queue.offer(8);
        queue.offer(90);

        System.out.println(queue);
    }
}
