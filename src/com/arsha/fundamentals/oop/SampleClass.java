package com.arsha.fundamentals.oop;

import com.arsha.fundamentals.oop.abstraction.AbstractSampleClass;
import com.arsha.fundamentals.oop.interfaces.SampleInterface;

public class SampleClass extends AbstractSampleClass implements SampleInterface {

    /**
     *  static blocs just run once and shared between all instances
     */
    static {
        System.out.println("Sample class static block");
    }

    @Override
    public void method1() {
        // Definition of this method is in AbstractSampleClass
    }

    @Override
    public void doSomething() {
        // Interface method
    }
}