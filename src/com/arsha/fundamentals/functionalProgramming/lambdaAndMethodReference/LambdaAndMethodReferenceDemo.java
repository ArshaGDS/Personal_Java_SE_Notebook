package com.arsha.fundamentals.functionalProgramming.lambdaAndMethodReference;

import java.awt.*;

public class LambdaAndMethodReferenceDemo {

    public static void main(String[] args) {

        // Lambda function demo

        // Demo 1
        OrderManager orderManager = new OrderManager(new DistanceCalculator() {
            @Override
            public double distance(Point p1, Point p2) {
                return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
            }
        });

        //---------------------------

        // Demo 2
        OrderManager orderManager2 = new OrderManager(new DefaultDistanceCalculator());
        orderManager2.SetDistanceCalculator(new DistanceCalculator() {
            @Override
            public double distance(Point p1, Point p2) {
                return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
            }
        });

        // Or

        orderManager2.SetDistanceCalculator((p1, p2) -> Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)));

        //---------------------------

        // Demo 3
        DistanceCalculator distanceCalculator = ((p1, p2) -> Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)));

        OrderManager orderManager3 = new OrderManager(distanceCalculator);
        // Or
        OrderManager orderManager3_1 = new OrderManager(new DefaultDistanceCalculator());
        orderManager3_1.SetDistanceCalculator(distanceCalculator);

        //---------------------------

        // Demo 4
        DistanceCalculator distanceCalculator2 = (Point p1, Point p2) -> {
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        };

        OrderManager orderManager4 = new OrderManager(distanceCalculator2);
        // Or
        OrderManager orderManager4_1 = new OrderManager(new DefaultDistanceCalculator());
        orderManager4_1.SetDistanceCalculator(distanceCalculator2);

        //---------------------------

        // Method reference demo

        OrderManager orderManager5 = new OrderManager(new DefaultDistanceCalculator());
        orderManager5.SetDistanceCalculator(ThirdPartyDistanceCalculator::calculateDistanceStatic);

        // Or

        ThirdPartyDistanceCalculator thirdPartyDistanceCalculator = new ThirdPartyDistanceCalculator();
        OrderManager orderManager6 = new OrderManager(new DefaultDistanceCalculator());
        orderManager6.SetDistanceCalculator(thirdPartyDistanceCalculator::calculateDistance);
    }
}
