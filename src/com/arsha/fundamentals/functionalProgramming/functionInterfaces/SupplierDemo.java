package com.arsha.fundamentals.functionalProgramming.functionInterfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<LocalDateTime> currentTimeSupplier = LocalDateTime::now;
        System.out.println(currentTimeSupplier.get());

        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get());

        // Lazy Initialization)
        Supplier<HeavyObject> heavyObjectSupplier = HeavyObject::new;
        HeavyObject obj = heavyObjectSupplier.get();
    }

    private static class HeavyObject {
    }
}
