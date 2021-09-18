package com.fp.util.mapper;

import com.fp.model.Invoice;
import com.fp.model.Order;
import com.fp.model.Shipping;
import com.fp.util.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.fp.util.Configuration.InvoiceToShipping.*;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class InvoiceToShippingMapper {

    private Map<Integer, Function<Invoice, Shipping>> invoiceToShippingFunctios = new HashMap<>();

    public InvoiceToShippingMapper() {
        invoiceToShippingFunctios.put(SHIPPING1.getValue(), this::getShipping1);
        invoiceToShippingFunctios.put(SHIPPING2.getValue(), this::getShipping2);
        invoiceToShippingFunctios.put(SHIPPING3.getValue(), this::getShipping3);
        invoiceToShippingFunctios.put(SHIPPING4.getValue(), this::getShipping4);
        invoiceToShippingFunctios.put(SHIPPING5.getValue(), this::getShipping5);

    }

    private Shipping getShipping1(Invoice invoice) {
        System.out.println("Shipping 1");
        return new Shipping(invoice.getCost() * 1, 1);
    }

    private Shipping getShipping2(Invoice invoice) {
        System.out.println("Shipping 1");
        return new Shipping(invoice.getCost() * 2, 2);
    }

    private Shipping getShipping3(Invoice invoice) {
        System.out.println("Shipping 3");
        return new Shipping(invoice.getCost() * 3, 3);
    }

    private Shipping getShipping4(Invoice invoice) {
        System.out.println("Shipping 4");
        return new Shipping(invoice.getCost() * 4, 4);
    }

    private Shipping getShipping5(Invoice invoice) {
        System.out.println("Shipping 5");
        return new Shipping(invoice.getCost() * 5, 5);
    }

    public Function<Invoice, Shipping> getInvoiceToShippingFunctio(int value) {
        return invoiceToShippingFunctios.get(value);
    }
}
