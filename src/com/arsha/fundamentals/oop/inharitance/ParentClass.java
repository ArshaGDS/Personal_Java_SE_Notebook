package com.arsha.fundamentals.oop.inharitance;

public class ParentClass {

    public ParentClass() {
        System.out.println("ParentClass");
    }

    public ParentClass(String name) {
        System.out.println("ParentClass, " + name);
    }

    static {
        System.out.println("ParentClass static init block");
    }

    {
        System.out.println("ParentClass init block");
    }
}
