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
public class Invoice {

    private double cost;

    @Override
    public String toString() {
        return "Invoice{" +
                "cost=" + cost +
                '}';
    }
}
