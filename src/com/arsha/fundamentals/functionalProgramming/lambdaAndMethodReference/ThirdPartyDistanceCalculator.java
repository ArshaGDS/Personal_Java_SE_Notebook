package com.arsha.fundamentals.functionalProgramming.lambdaAndMethodReference;

import java.awt.*;

public class ThirdPartyDistanceCalculator {

    public double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static double calculateDistanceStatic(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
