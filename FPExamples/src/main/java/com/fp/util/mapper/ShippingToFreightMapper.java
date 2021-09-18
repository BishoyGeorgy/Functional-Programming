package com.fp.util.mapper;

import com.fp.model.Freight;
import com.fp.model.Invoice;
import com.fp.model.Order;
import com.fp.model.Shipping;
import com.fp.util.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fp.util.Configuration.ShippingToFreight.*;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class ShippingToFreightMapper {

    private Map<Integer, Function<Shipping, Freight>> shippingToFreightFunctions = new HashMap<>();

    public ShippingToFreightMapper() {
        shippingToFreightFunctions.put(FREIGHT1.getValue(), this::getFreight1);
        shippingToFreightFunctions.put(FREIGHT2.getValue(), this::getFreight2);
        shippingToFreightFunctions.put(FREIGHT3.getValue(), this::getFreight3);

    }

    private Freight getFreight1(Shipping shipping) {
        System.out.println("Freight 1");
        return new Freight(shipping.getCost() * 1);
    }

    private Freight getFreight2(Shipping shipping) {
        System.out.println("Freight 2");
        return new Freight(shipping.getCost() * 2);
    }

    private Freight getFreight3(Shipping shipping) {
        System.out.println("Freight 3");
        return new Freight(shipping.getCost() * 3);
    }

    public Function<Shipping, Freight> getShippingFreightFunction(int value) {
        return shippingToFreightFunctions.get(value);
    }
}
