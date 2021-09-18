package com.fp.util.mapper;

import com.fp.model.Invoice;
import com.fp.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fp.util.Configuration.OrderToInvoice.*;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class OrderToInvoiceMapper {

    private Map<Integer, Function<Order, Invoice>> orderToInvoiceFunctions = new HashMap<>();

    public OrderToInvoiceMapper() {
        orderToInvoiceFunctions.put(INVOICE1.getValue(), this::getInvoice1);
        orderToInvoiceFunctions.put(INVOICE2.getValue(), this::getInvoice2);
        orderToInvoiceFunctions.put(INVOICE3.getValue(), this::getInvoice3);
    }

    private Invoice getInvoice1(Order order) {
        System.out.println("Invoice 1");
        return new Invoice(order.getPrice() * 1);
    }

    private Invoice getInvoice2(Order order) {
        System.out.println("Invoice 2");
        return new Invoice(order.getPrice() * 2);
    }

    private Invoice getInvoice3(Order order) {
        System.out.println("Invoice 3");
        return new Invoice(order.getPrice() * 3);
    }

    public Function<Order, Invoice> getOrderToInvoiceFunction(int value) {
        return orderToInvoiceFunctions.get(value);
    }
}
