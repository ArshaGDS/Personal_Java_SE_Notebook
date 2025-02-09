package com.arsha.fundamentals.oop.solid.liskovSubstitutionPrinciple;

public class Penguin implements Bird {

    @Override
    public void eat() {
        System.out.println("Sparrow eating");
    }
}
