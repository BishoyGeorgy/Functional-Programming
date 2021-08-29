package com.fp.session2;

import com.fp.util.CalculationsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 27/08/2021
 */
public class SequencedOperations {

    public static void main (String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(7.0);
        numbers.add(4.0);
        numbers.add(5.0);
        numbers.add(6.0);
        numbers.add(3.0);
        numbers.add(8.0);
        numbers.add(10.0);

        //1st Example
        List<Double> result1 = numbers.stream().map(CalculationsUtil::addOne)
                                               .map(CalculationsUtil::square)
                                               .map(CalculationsUtil::subtractTen)
                                               .collect(Collectors.toList());

        result1.forEach(number -> System.out.println(number));
        System.out.println("------------------");

        //2nd Example
        List<Double> result2 = numbers.stream().map(CalculationsUtil::addOne)
                                               .map(CalculationsUtil::square)
                                               .filter( x -> x < 20)
                                               .map(CalculationsUtil::subtractTen)
                                               .collect(Collectors.toList());

        result2.forEach(number -> System.out.println(number));
        System.out.println("------------------");

        //3rd Example
        List<Double> result3 = numbers.stream().map(CalculationsUtil::addOne)
                                               .map(CalculationsUtil::square)
                                               .filter( x -> x < 70)
                                               .sorted()
                                               .limit(2)
                                               .map(CalculationsUtil::subtractTen)
                                               .collect(Collectors.toList());

        result3.forEach(number -> System.out.println(number));
        System.out.println("------------------");
    }
}
