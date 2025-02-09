package com.arsha.fundamentals.oop.nestedClass;

public class NestedClassExample {

    // Package private
    class NestedClass {

        private int field;
    }

    // Package private - can't create instance of it
    static class NestedClass2 {

        private int field;
    }

    public class NestedClass3 {

        private int field;
    }

    // Can't create instance of it
    public static class NestedClass4 {

        private int field;
    }
}
