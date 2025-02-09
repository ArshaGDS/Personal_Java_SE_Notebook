package com.arsha.fundamentals.oop.inharitance;

/**
 * Output:
 * ParentClass static init block
 * ChildClass static init block
 * ParentClass init block
 * ParentClass
 * ChildClass init block
 * ChildClass
 */
public class ChildClass extends ParentClass {

    public ChildClass() {
        System.out.println("ChildClass");
    }

    static {
        System.out.println("ChildClass static init block");
    }

    {
        System.out.println("ChildClass init block");
    }
}
