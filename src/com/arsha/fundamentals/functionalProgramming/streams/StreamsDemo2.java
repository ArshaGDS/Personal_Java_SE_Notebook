package com.arsha.fundamentals.functionalProgramming.streams;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class StreamsDemo2 {

    public static void main(String[] args) {

        Random rand = new Random();
        Present present = new Present();
        for (int i = 0; i < 15; i++) {
            present.addSweet(new Lollipop("Lollipop" + i, rand.nextFloat(100), rand.nextFloat(100)));
        }

        System.out.println(Arrays.toString(present.getSweets()));
        System.out.println(present.calculateTotalWeight());
        System.out.println(Arrays.toString(present.filterSweetsBySugarRange(10, 20)));
    }

    abstract static class Sweet {

        private String name;
        private float weight;
        private float sugarWeight;

        public Sweet(String name, float weight, float sugarWeight) {
            this.name = name;
            this.weight = weight;
            this.sugarWeight = sugarWeight;
        }

        @Override
        public String toString() {
            return  "\n{" +
                    "name='" + name + '\'' +
                    ", weight=" + weight +
                    ", sugarWeight=" + sugarWeight +
                    "}\n";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public float getSugarWeight() {
            return sugarWeight;
        }

        public void setSugarWeight(float sugarWeight) {
            this.sugarWeight = sugarWeight;
        }
    }

    static class Present {

        private final Sweet[] sweets;
        private final int SWEETS_ARRAY_SIZE = 10;
        private int lastIndexAdded = 0;

        {
            sweets = new Sweet[SWEETS_ARRAY_SIZE];
        }

        // the method filters sweets by sugar weight inclusively 
        public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
            return Arrays.stream(sweets)
                    .filter(Objects::nonNull)
                    .filter(sweet -> sweet.sugarWeight >= minSugarWeight && sweet.sugarWeight <= maxSugarWeight)
                    .toArray(Sweet[]::new);
        }

        // the method calculates total weight of the present
        public double calculateTotalWeight() {
            return Arrays.stream(sweets)
                    .mapToDouble(Sweet::getWeight)
                    .sum();
        }

        // the method that adds sweet to the present
        public void addSweet(Sweet sweet) {
            if (sweet == null) { return; }
            if (lastIndexAdded >= SWEETS_ARRAY_SIZE) { return; }

            sweets[lastIndexAdded++] = sweet;
        }

        // the method returns copy of the Sweet[] array so that nobody could 
        // modify state of the present without addSweet() method.
        // Also array shouldn’t contain null values.
        public Sweet[] getSweets() {
            return Arrays.stream(sweets).filter(Objects::nonNull).toArray(Sweet[]::new);
        }
    }

    static class Cookie extends Sweet {

        public Cookie(String name, float weight, float sugarWeight) {
            super(name, weight, sugarWeight);
        }
    }

    static class Candy extends Sweet {

        public Candy(String name, float weight, float sugarWeight) {
            super(name, weight, sugarWeight);
        }
    }

    static class Lollipop extends Sweet {

        public Lollipop(String name, float weight, float sugarWeight) {
            super(name, weight, sugarWeight);
        }
    }
}
