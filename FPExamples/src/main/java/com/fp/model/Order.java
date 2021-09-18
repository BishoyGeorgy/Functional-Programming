package com.fp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 27/08/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private int orderId;
    private int productIndex;
    private int quantity;
    private int price;
    private double discount;

    @Override
    public String toString() {
        return "OrderId: " + this.orderId + ", Price: " + this.price + ", Quantity: " + this.quantity + ", Discount: " + this.discount;
    }
}
