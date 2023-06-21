package com.example.lambdaexamples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;

public class Test_0_Basics {

    /**
     * example - consumer, supplier, function, predicate
     * syntax - with params, with parenthesis, w/o params
     * parenthesis, with method reference
     */

    @Test
    void basicConsumer() {
        Consumer<String> customPrinter = s -> System.out.println(s);
//        Consumer<String> customPrinter = System.out::println;
        customPrinter.accept("Hello");
    }

    @Test
    void basicSupplier() {
        String expected = "Some string";
        Supplier<String> stringSupplier = () -> {return "Some string";};
//        Supplier<String> stringSupplier = this::supplySomeString;
        assertEquals(expected, stringSupplier.get());
    }

    private String supplySomeString() {
        return "Some string";
    }

    @Test
    void basicFunction() {
        Function<Integer, Integer> integerMultiply10 = (x) -> x * 10;
        assertEquals(100, integerMultiply10.apply(10));
    }

    @Test
    void basicPredicate() {
        Predicate<String> stringPredicate = (x) -> x.equals("Hello");
//        Predicate<String> stringPredicate = (x) -> true;
        assertTrue(stringPredicate.test("Hello"));
    }

    @Test
    void basicBiConsumer() {
        BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println(s + i);
//        BiConsumer<String, Integer> biConsumer = (String s, Integer i) -> System.out.println(s + i);
//        BiConsumer<String, Integer> biConsumer = (String s, Integer i) -> {
//            System.out.println(s + i); //no return because it's a consumer
//        };
        biConsumer.accept("Hello: ", 10);
    }

    //no BiSupplier, the reason is that method can return only one type of value;

    @Test
    void basicBiFunction() {
        BiFunction<Integer, Integer, Integer> squareBiFunction = (x, y) -> x * y;
//        BiFunction<Integer, Integer, Integer> squareBiFunction = (Integer x, Integer y) -> x * y;
//        BiFunction<Integer, Integer, Integer> squareBiFunction = (Integer x, Integer y) -> {
//            return x * y;
//        };

        Integer expectedSquare = 12;
        assertEquals(expectedSquare, squareBiFunction.apply(3, 4));
    }

    @Test
    void basicBiPredicate() {
        BiPredicate<String, Integer> biPredicateCompareStringNumber = (s, i) -> s.equals(i.toString());
//        BiPredicate<String, Integer> biPredicateCompareStringNumber = (String s, Integer i) -> s.equals(i.toString());
//        BiPredicate<String, Integer> biPredicateCompareStringNumber = (String s, Integer i) -> {
//            return s.equals(i.toString());
//        };

        assertTrue(biPredicateCompareStringNumber.test("10", 10));
    }

}
