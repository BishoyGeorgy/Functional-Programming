package com.fp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingDate {

    private Date shippingDate;

    @Override
    public String toString() {
        return "ShippingDate{" +
                "shippingDate=" + shippingDate +
                '}';
    }
}
