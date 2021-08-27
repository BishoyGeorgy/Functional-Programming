package com.fp.session3;


import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 27/08/2021
 */
public class ProductDiscountCalculation {

    private static Function<Integer, Double[]> foodFunction = new Function<Integer, Double[]>() {
        @Override
        public Double[] apply(Integer productIndex) {
            return productParametersFood(productIndex);
        }
    };

    private static Function<Integer, Double[]> beverageFunction = new Function<Integer, Double[]>() {
        @Override
        public Double[] apply(Integer productIndex) {
            return productParametersBeverage(productIndex);
        }
    };

    private static Function<Integer, Double[]> rawMaterialFunction = new Function<Integer, Double[]>() {
        @Override
        public Double[] apply(Integer productIndex) {
            return productParametersRawMaterial(productIndex);
        }
    };

    public static void main (String [] args) {
        String productType = "Food";
        Order order = new Order(10, 100, 20, 4);
        Function<Integer, Double[]> parameterFunction = productType.equals("Food") ? foodFunction : productType.equals("beverage") ? beverageFunction : rawMaterialFunction;

        System.out.println(calculateDiscount(parameterFunction, order));
    }

    private static double calculateDiscount(Function<Integer, Double[]> parameterFunction, Order order) {
        Double[] parameters = parameterFunction.apply(order.getProductIndex());
        return  parameters[0] * order.getQuantity() + parameters[1] * order.getPrice();
    }

    private static Double[] productParametersFood(int productIndex) {
        return new Double[] {productIndex / (double) productIndex + 100, productIndex / (double) productIndex + 300};
    }

    private static Double[] productParametersBeverage(int productIndex) {
        return new Double[] {productIndex / (double) productIndex + 300, productIndex / (double) productIndex + 400};
    }

    private static Double[] productParametersRawMaterial(int productIndex) {
        return new Double[] {productIndex / (double) productIndex + 400, productIndex / (double) productIndex + 700};
    }
}
