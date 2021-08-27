package com.fp.session4;

import com.fp.util.Order;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 27/08/2021
 */
public class OrdersWithDiscount {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, 100, 10, 5, 0.0));
        orders.add(new Order(2, 200, 20, 10, 0.0));
        orders.add(new Order(3, 300, 30, 15, 0.0));
        orders.add(new Order(4, 400, 40, 20, 0.0));
        orders.add(new Order(5, 500, 50, 25, 0.0));

        List<Order> ordersWithDiscount = orders.stream()
                                               .map(order -> getOrderWithDiscount(order, OrderRules.getRules()))
                                               .collect(Collectors.toList());

        ordersWithDiscount.forEach(order -> System.out.println(order));
    }

    private static Order getOrderWithDiscount(Order order, Map<Function<Order, Boolean>, Function<Order, Double>> rules) {
        OptionalDouble discount =
        rules.entrySet().stream().filter(e -> e.getKey().apply(order))
                                 .mapToDouble(e -> e.getValue().apply(order))
                                 .average();
        order.setDiscount(discount.isPresent() ? discount.getAsDouble() : 0.0);

        return order;
    }
}
