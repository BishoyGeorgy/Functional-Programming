package com.fp.util.mapper;

import com.fp.model.Availability;
import com.fp.model.Shipping;
import com.fp.model.ShippingDate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fp.util.Configuration.AvailabilityToShippingDate.*;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class AvailabilityToShippingDateMapper {

    private Map<Integer, Function<Availability, ShippingDate>> availabilityToShippingDate = new HashMap<>();

    public AvailabilityToShippingDateMapper() {
        availabilityToShippingDate.put(SHIPPING_DATE1.getValue(), this::getShippingDate1);
        availabilityToShippingDate.put(SHIPPING_DATE2.getValue(), this::getShippingDate2);
        availabilityToShippingDate.put(SHIPPING_DATE3.getValue(), this::getShippingDate3);
        availabilityToShippingDate.put(SHIPPING_DATE4.getValue(), this::getShippingDate4);
    }

    private ShippingDate getShippingDate1(Availability availability) {
        System.out.println("Shipping Date 1");
        return new ShippingDate(new Date(availability.getAvailabilityDate().getTime()));
    }

    private ShippingDate getShippingDate2(Availability availability) {
        System.out.println("Shipping Date 2");
        return new ShippingDate(new Date(availability.getAvailabilityDate().getTime()));
    }

    private ShippingDate getShippingDate3(Availability availability) {
        System.out.println("Shipping Date 3");
        return new ShippingDate(new Date(availability.getAvailabilityDate().getTime()));
    }

    private ShippingDate getShippingDate4(Availability availability) {
        System.out.println("Shipping Date 4");
        return new ShippingDate(new Date(availability.getAvailabilityDate().getTime()));
    }

    public Function<Availability, ShippingDate> getAvailabilityShippingDateFunction(int value) {
        return availabilityToShippingDate.get(value);
    }
}
