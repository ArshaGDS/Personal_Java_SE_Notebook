package com.arsha.fundamentals.functionalProgramming.functionInterfaces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FunctionsDemo {

    public static void main(String[] args) {

        Function<Integer, Integer> plus = x -> x + 2;
        Function<Integer, String> intToString = String::valueOf;

        int number = plus.apply(5);
        System.out.println(intToString.apply(number));

        //---------------------------

        Function<Integer, String> pipeline1 =  plus.andThen(intToString);
        System.out.println(pipeline1.apply(5));

        //---------------------------

        Function<Integer, Integer> f = x -> x * x;
        Function<Integer, Integer> g = x -> x - 2;

        Function<Integer, Integer> compose = f.compose(g);
        Function<Integer, Integer> andThen = f.andThen(g);

        System.out.println(compose.apply(5));
        System.out.println(andThen.apply(5));

        //---------------------------

        InitProdList initProdList = () -> {
            final int PRODUCT_SIZE = 10;
            List<Product> products = new ArrayList<>();
            Random random = new Random();
            for(int i = 0; i < PRODUCT_SIZE; i++) {
                products.add(
                        new Product(i, "Prod" + i, random.nextInt(100))
                );
            }
            return products;
        };

        List<Product> products = initProdList.initialList();
        System.out.println("Products: " + products);

        products.sort(Comparator.comparing(product -> product.productId));
        System.out.println("Sorted by ID: " + products);

        products.sort(Comparator.comparing(Product::getProductPrice));
        System.out.println("Sorted by Price: " + products);
    }

    private static class Product {

        private final int productId;
        private final String productName;
        private final int productPrice;

        public Product(int productId, String productName, int productPrice) {
            this.productId = productId;
            this.productName = productName;
            this.productPrice = productPrice;
        }

        public int getProductId() {
            return productId;
        }

        public int getProductPrice() {
            return productPrice;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "Name='" + productName + '\'' +
                    ", Price=" + productPrice +
                    '}';
        }
    }

    @FunctionalInterface
    private interface InitProdList {
        List<Product> initialList();
    }
}
