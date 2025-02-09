package com.arsha.fundamentals.functionalProgramming.lambdaAndMethodReference;

public class OrderManager {

    DistanceCalculator distanceCalculator;

    public OrderManager(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    public void SetDistanceCalculator(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
}
