package com.fp.util.mapper;

import com.fp.model.Availability;
import com.fp.model.Order;
import com.fp.util.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fp.util.Configuration.OrderToAvailabilty.*;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class OrderToAvailabilityMapper {

    private Map<Integer, Function<Order, Availability>> orderToAvailabiltyFunctions = new HashMap<>();

    public OrderToAvailabilityMapper() {
        orderToAvailabiltyFunctions.put(AVAILABILTY1.getValue(), this::getAvailability1);
        orderToAvailabiltyFunctions.put(AVAILABILTY2.getValue(), this::getAvailability2);
        orderToAvailabiltyFunctions.put(AVAILABILTY3.getValue(), this::getAvailability3);
    }

    private Availability getAvailability1(Order order) {
        System.out.println("Availability 1");
        return new Availability(new Date(2000, 1, 1));
    }

    private Availability getAvailability2(Order order) {
        System.out.println("Availability 2");
        return new Availability(new Date(2010, 1, 1));
    }

    private Availability getAvailability3(Order order) {
        System.out.println("Availability 3");
        return new Availability(new Date(2020, 1, 1));
    }

    public Function<Order, Availability> getOrderAvailabilityFunction(int value) {
        return orderToAvailabiltyFunctions.get(value);
    }
}
