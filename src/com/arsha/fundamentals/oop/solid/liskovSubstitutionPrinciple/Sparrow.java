package com.arsha.fundamentals.oop.solid.liskovSubstitutionPrinciple;

public class Sparrow implements FlyingBird {

    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }
}
