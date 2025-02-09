package com.arsha.fundamentals.generics;

public class GenericSample2<E extends Number & Comparable<E>> {

    E element;

    public GenericSample2(E element) {
        this.element = element;
    }

    public int compareTo(E element) {
        if (element == null) return -1;
        return this.element.compareTo(element);
    }
}
