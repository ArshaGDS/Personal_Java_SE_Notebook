package com.arsha.fundamentals.functionalProgramming.lambdaAndMethodReference;

import java.awt.*;

@FunctionalInterface
public interface DistanceCalculator {

    double distance(Point p1, Point p2);
}
