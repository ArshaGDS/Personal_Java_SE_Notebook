package com.arsha.fundamentals.generics;

public class GenericSample <E extends Comparable<E>> {

    E element;

    public GenericSample(E element) {
        this.element = element;
    }

    public int compareTo(E element) {
        if (element == null) return -1;
        return this.element.compareTo(element);
    }
}
