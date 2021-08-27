package com.fp.session4;

import com.fp.util.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 27/08/2021
 */
public class OrderRules {

    public static Map<Function<Order, Boolean>, Function<Order, Double>> getRules() {
        Map<Function<Order, Boolean>, Function<Order, Double>> rules = new HashMap<>();
        rules.put(OrderRules::qualifyOrderId, OrderRules::calculateOrderIdDiscount);
        rules.put(OrderRules::qualifyPrice, OrderRules::calculatePriceDiscount);
        rules.put(OrderRules::qualifyQuantity, OrderRules::calculateQuantityDiscount);

        return rules;
    }

    private static boolean qualifyPrice(Order order) {
        return order.getPrice() > 20;
    }

    private static double calculatePriceDiscount(Order order) {
        return (double) order.getPrice() / 2;
    }

    private static boolean qualifyQuantity(Order order) {
        return order.getQuantity() > 20;
    }

    private static double calculateQuantityDiscount(Order order) {
        return (double) order.getPrice() / 3;
    }

    private static boolean qualifyOrderId(Order order) {
        return order.getOrderId() > 1;
    }

    private static double calculateOrderIdDiscount(Order order) {
        return (double) order.getPrice() / 10;
    }
}
