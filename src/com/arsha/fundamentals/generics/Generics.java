package com.arsha.fundamentals.generics;

import com.arsha.fundamentals.stringExamples.Person;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Generics {

    public static void main(String[] args) {

        printElement("String");
        printElement(12);
        printElement(12.f);
        printElement(12.d);

        Person person = new Person("Arsha", 12);
        printElement(person);

        //========================================

        GenericSample<String> genericSample = new GenericSample<>("Arsha");
        printElement(genericSample.compareTo(new String("Arshaa")));
        printElement(genericSample.compareTo(new String("Arsha")));

        //========================================

        // GenericSample2<String> genericSample2 = new GenericSample2<>("Arsha"); Error
        GenericSample2<Integer> genericSample2 = new GenericSample2<>(15454545);
        printElement(genericSample2.compareTo(12));

        GenericSample2<Float> genericSample2_2 = new GenericSample2<>(12.f);
        printElement(genericSample2_2.compareTo(12.f));

        //========================================

        setChildElement(new GenericElement<ParentClass>());
        setChildElement(new GenericElement<ChildClass>());
        // setChildElement(new GenericElement<GrandChildClass>()); Error

        // setChildElement2(new GenericElement<ParentClass>()); Error
        setChildElement2(new GenericElement<ChildClass>());
        setChildElement2(new GenericElement<GrandChildClass>());

    }

    // Generic method
    private static <E> void printElement(E element) {
        System.out.println(element);
    }

    // Generic method with wild card
    private static void setChildElement(GenericElement<? super ChildClass> element) {
        // Lower Bounded Wildcard
    }

    private static void setChildElement2(GenericElement<? extends ChildClass> element) {
        // Upper Bounded Wildcard
    }

    private static void setChildAllElement(ArrayList<? super GrandChildClass> list) {

    }

    private static class GenericElement<T> {}

    private static class ParentClass {}

    private static class ChildClass extends ParentClass {}

    private static class GrandChildClass extends ChildClass {}
}
