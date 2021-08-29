package com.fp.session5;

import com.fp.util.CalculationsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.fp.util.CalculationsUtil.*;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 29/08/2021
 */
public class FRFExamples {

    private static Function<Double, Double> addOneDlgt = CalculationsUtil::addOne;
    private static Function<Double, Double> squareDlgt = CalculationsUtil::square;
    private static Function<Double, Double> subtractTenDlgt = CalculationsUtil::subtractTen;

    public static void main (String[] args) {
        List<Double> numbers = new ArrayList<>();
        numbers.add(3.0);
        numbers.add(5.0);
        numbers.add(7.0);
        numbers.add(8.0);

        //1st Example
        numbers.stream().map(addOneDlgt)
                        .map(squareDlgt)
                        .map(subtractTenDlgt)
                        .forEach(number -> System.out.println(number));

        System.out.println("------------------");

        //2nd Example
        numbers.stream().map(x -> subtractTen(square(addOne(x))))
                        .forEach(number -> System.out.println(number));

        System.out.println("------------------");

        //3rd Example
        Function<Double, Double> myComposedFunction = composeFunctions(addOneDlgt, squareDlgt, subtractTenDlgt);
        numbers.stream().map(myComposedFunction)
                        .forEach(number -> System.out.println(number));

        System.out.println("------------------");

        //4th Example
        Function<Double, Double> addOneSquare = composeFunctions(addOneDlgt, squareDlgt);
        Function<Double, Double> addOneSquareSubtractTen = composeFunctions(addOneSquare, subtractTenDlgt);
        numbers.stream().map(addOneSquareSubtractTen)
                        .forEach(number -> System.out.println(number));

        System.out.println("------------------");

        //The 4th example using andThen and compose methos in the Finction itself
        Function<Double, Double> andThen = addOneDlgt.andThen(squareDlgt).andThen(subtractTenDlgt);
        numbers.stream().map(andThen)
                        .forEach(number -> System.out.println(number));

        Function<Double, Double> composed = subtractTenDlgt.compose(squareDlgt).compose(addOneDlgt);
        numbers.stream().map(composed)
                        .forEach(number -> System.out.println(number));

        System.out.println("------------------");
    }

    private static Function<Double, Double> composeFunctions(Function<Double, Double> addOneDlgt, Function<Double, Double> squareDlgt, Function<Double, Double> subtractTenDlgt) {
        return x -> subtractTenDlgt.apply(squareDlgt.apply(addOneDlgt.apply(x)));
    }

    private static <T, K, R> Function<T, K> composeFunctions(Function<T, R> f1, Function<R, K> f2) {
        return x -> f2.apply(f1.apply(x));
    }
}
