package com.arsha.fundamentals.exceptions;

import java.io.IOException;

public class ExceptionManager {

    public ExceptionManager(Exception e) {

        if (e instanceof IllegalArgumentException) {
            System.out.println("IllegalArgumentException");
        }

        if (e instanceof NullPointerException) {
            System.out.println("NullPointerException");
        }

        if (e instanceof ArithmeticException) {
            System.out.println("ArithmeticException");
        }

        if (e instanceof ArrayIndexOutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }

        if (e instanceof NotEnoughMoneyException) {
            System.out.println("NotEnoughMoneyException");
        }

        if (e instanceof IOException) {
            System.out.println("I/O Exception");
        }
    }
}
