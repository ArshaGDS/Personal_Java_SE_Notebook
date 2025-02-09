package com.arsha.fundamentals.stringExamples;

public class Person {

    public String name;
    public int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        if (person != null) return false;
        return this.name.equals(person.name) && this.age == person.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
