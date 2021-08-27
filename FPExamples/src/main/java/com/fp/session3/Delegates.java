package com.fp.session3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 27/08/2021
 */
public class Delegates {

    private static Function<Double, Double> dlgtTest1 = Delegates::test1;
    private static Function<Double, Double> dlgtTest2 = Delegates::test2;

    public static void main (String[] args) {
        List<Function<Double, Double>> list = new ArrayList<>();
        list.add(dlgtTest1);
        list.add(dlgtTest2);

        // Using simple Calling methods
        System.out.println(test2(test1(5.0)));
        System.out.println(test1(test2(5.0)));

        // Using the delegates from the list
        System.out.println(list.get(0).apply(5.0));
        System.out.println(list.get(1).apply(5.0));

        // Using The Higher Order Function
        System.out.println(test(list.get(0), 5.0));
        System.out.println(test(list.get(1), 5.0));
    }

    // Higher Order Function
    private static double test(Function<Double, Double> function, double v) {
        return function.apply(v) + v;
    }

    private static double test1(double x) {
        return x / 2;
    }

    private static double test2(double x) {
        return x / 4 + 1;
    }
}
