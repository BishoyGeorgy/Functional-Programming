package com.fp.session7;

import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 18/09/2021
 */
public class ClosureSyntax {

    public static void main(String args[]) {
        Function<Double, Double> testFunction1 = test(10);
        Function<Double, Double> testFunction2 = test(20);

        System.out.println(testFunction1.apply(4.0));
        System.out.println(testFunction2.apply(4.0));
    }

    private static Function<Double, Double> test(double x) {
        System.out.println("I am Here " + x);

        double x1 = x + 10;

        return (a) -> {
            return a + x1;
        };
    }
}
