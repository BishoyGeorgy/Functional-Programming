package com.fp.session3;

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
}
