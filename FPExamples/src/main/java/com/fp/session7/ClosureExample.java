package com.fp.session7;

import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 18/09/2021
 */
public class ClosureExample {

    public static void main(String[] args) {
        System.out.println(calculateSalary(2000, 200));
        System.out.println(calculateSalary(2000, 300));
        System.out.println(calculateSalary(2000, 400));
        System.out.println(calculateSalary(3000, 200));
        System.out.println(calculateSalary(3000, 300));
        System.out.println(calculateSalary(4000, 200));
        System.out.println(calculateSalary(5000, 200));
        System.out.println(calculateSalary(4000, 300));
    }
    private static double calculateSalary(double basicSalary, double bonus) {
        Function<Double, Double> bonusFunctionByBasicSalary = SalaryCalculator.getBonusFunctionByBasicSalary(basicSalary);
        return bonusFunctionByBasicSalary.apply(bonus);
    }
}
