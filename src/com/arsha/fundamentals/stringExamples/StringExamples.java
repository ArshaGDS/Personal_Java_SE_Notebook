package com.arsha.fundamentals.stringExamples;

public class StringExamples {

    public static void main(String[] args) {

        String a = "Ali";
        String b = "Ali";

        String c = new String("Ali");
        String d = new String("Ali").intern();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        System.out.println(a.equals(c));
        System.out.printf("a == c: %b and a.equals(c): %b \n", a == c, a.equals(c));
        System.out.printf("a == d: %b and a.equals(d): %b \n", a == d, a.equals(d));
    }

}