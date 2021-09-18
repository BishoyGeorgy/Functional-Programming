package com.fp.session6;

import com.fp.model.Freight;
import com.fp.model.Order;
import com.fp.model.ShippingDate;

import java.util.function.Function;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class CostForOrder {

    public static void main(String args[]) {

        Order order = new Order(1, 100, 10, 5, 0.0);
        System.out.println(adjustFreightForOrder(order));
    }

    private static double adjustFreightForOrder(Order order) {
        Function<Order, Freight> orderFreightFunction = OrderToFreightPath.getOrderFreightFunction();
        Function<Order, ShippingDate> orderShippingDateFunction = OrderToShippingDatePath.getOrderShippingDateFunction();

        return adjustCost(order, orderFreightFunction, orderShippingDateFunction);
    }

    private static double adjustCost(Order order, Function<Order, Freight> orderFreightFunction, Function<Order, ShippingDate> orderShippingDateFunction){
        Freight freight = orderFreightFunction.apply(order);
        ShippingDate shippingDate = orderShippingDateFunction.apply(order);

        System.out.println("Cost: " + freight.getCost() + ", Day of Shipping: " + shippingDate.getShippingDate().getTime());

        return freight.getCost();
    }
}
