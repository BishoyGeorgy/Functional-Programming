package com.fp.session6;

import com.fp.model.Availability;
import com.fp.model.Order;
import com.fp.model.ShippingDate;
import com.fp.util.mapper.AvailabilityToShippingDateMapper;
import com.fp.util.mapper.OrderToAvailabilityMapper;

import java.util.function.Function;

import static com.fp.util.Configuration.OrderToAvailabilty;
import static com.fp.util.Configuration.AvailabilityToShippingDate;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class OrderToShippingDatePath {

    private static OrderToAvailabilityMapper orderToAvailabilityMapper = new OrderToAvailabilityMapper();
    private static AvailabilityToShippingDateMapper availabilityToShippingDateMapper = new AvailabilityToShippingDateMapper();

    public static Function<Order, ShippingDate> getOrderShippingDateFunction() {
        Function<Order, Availability> orderAvailabilityFunction = getOrderAvailabilityFunction(OrderToAvailabilty.AVAILABILTY2);
        Function<Availability, ShippingDate> availabilityShippingDateFunction = getAvailabilityShippingDateFunction(AvailabilityToShippingDate.SHIPPING_DATE3);

        return composeFunctions(orderAvailabilityFunction, availabilityShippingDateFunction);
    }

    private static <T, K, R> Function<T, R> composeFunctions(Function<T, K> orderAvailabilityFunction, Function<K, R> availabilityShippingDateFunction) {
        return orderAvailabilityFunction.andThen(availabilityShippingDateFunction);
    }

    private static Function<Order, Availability> getOrderAvailabilityFunction(OrderToAvailabilty orderToAvailabilty) {
        return orderToAvailabilityMapper.getOrderAvailabilityFunction(orderToAvailabilty.getValue());
    }

    private static Function<Availability, ShippingDate> getAvailabilityShippingDateFunction(AvailabilityToShippingDate availabilityToShippingDate) {
        return availabilityToShippingDateMapper.getAvailabilityShippingDateFunction(availabilityToShippingDate.getValue());
    }
}
