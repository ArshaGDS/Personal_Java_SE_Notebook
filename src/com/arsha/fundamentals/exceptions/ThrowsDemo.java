package com.arsha.fundamentals.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsDemo {

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        //demo.someMethod();

        try {
            demo.someMethod();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void someMethod() throws FileNotFoundException {

    }

}


class ThrowsDemoOverride extends ThrowsDemo {

    // Exceptioni ke throw mikone bayad ba parentesh yeki bashe
    @Override
    public void someMethod() throws FileNotFoundException {

    }
}