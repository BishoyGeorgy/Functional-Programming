package com.fp.session7;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 18/09/2021
 */
public class SalaryCalculator {

    private static Map<Double, Function<Double, Double>> bonusFunctions = new HashMap<>();

    public static Function<Double, Double> getBonusFunctionByBasicSalary(double basicSalary) {
        Function<Double, Double> currentBonusFunction = bonusFunctions.get(basicSalary);
        if (currentBonusFunction != null) return currentBonusFunction;

        currentBonusFunction = calculateGrossSalary(basicSalary);
        bonusFunctions.put(basicSalary, currentBonusFunction);

        return currentBonusFunction;
    }

    private static Function<Double, Double> calculateGrossSalary(double basicSalary) {
        System.out.println("I am Here, calculateGrossSalary: " + basicSalary);
        double tax = 0.2 * basicSalary;

        return (bonus) -> {
            return bonus + tax + basicSalary;
        };
    }
}
