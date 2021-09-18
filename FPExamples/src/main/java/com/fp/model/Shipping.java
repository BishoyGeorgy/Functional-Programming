package com.fp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipping {

    private double cost;
    private int shippingId;

    @Override
    public String toString() {
        return "Shipping{" +
                "cost=" + cost +
                ", shippingId=" + shippingId +
                '}';
    }
}
