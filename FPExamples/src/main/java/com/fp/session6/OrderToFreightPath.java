package com.fp.session6;

import com.fp.model.Freight;
import com.fp.model.Invoice;
import com.fp.model.Order;
import com.fp.model.Shipping;
import com.fp.util.mapper.InvoiceToShippingMapper;
import com.fp.util.mapper.OrderToInvoiceMapper;
import com.fp.util.mapper.ShippingToFreightMapper;

import java.util.function.Function;

import static com.fp.util.Configuration.OrderToInvoice;
import static com.fp.util.Configuration.InvoiceToShipping;
import static com.fp.util.Configuration.ShippingToFreight;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class OrderToFreightPath {

    private static OrderToInvoiceMapper orderToInvoiceMapper = new OrderToInvoiceMapper();
    private static InvoiceToShippingMapper invoiceToShippingMapper = new InvoiceToShippingMapper();
    private static ShippingToFreightMapper shippingToFreightMapper = new ShippingToFreightMapper();

    public static Function<Order, Freight> getOrderFreightFunction() {
        Function<Order, Invoice> orderInvoiceFunction = getOrderInvoiceFunction(OrderToInvoice.INVOICE1);
        Function<Invoice, Shipping> invoiceShippingFunction = getInvoiceShippingFunction(InvoiceToShipping.SHIPPING5);
        Function<Shipping, Freight> shippingFreightFunction = getShippingFreightFunction(ShippingToFreight.FREIGHT2);

        return composeFunctions(orderInvoiceFunction, invoiceShippingFunction, shippingFreightFunction);
    }

    private static <T, K, F, R> Function<T, R> composeFunctions(Function<T, K> orderToInvoice, Function<K, F> invoiceToShipping, Function<F, R> shippingToFreight) {
        return orderToInvoice.andThen(invoiceToShipping).andThen(shippingToFreight);
    }

    private static Function<Order, Invoice> getOrderInvoiceFunction(OrderToInvoice orderToInvoice) {
        return orderToInvoiceMapper.getOrderToInvoiceFunction(orderToInvoice.getValue());
    }

    private static Function<Invoice, Shipping> getInvoiceShippingFunction(InvoiceToShipping invoiceToShipping) {
        return invoiceToShippingMapper.getInvoiceToShippingFunctio(invoiceToShipping.getValue());
    }

    private static Function<Shipping, Freight> getShippingFreightFunction(ShippingToFreight shippingToFreight) {
        return shippingToFreightMapper.getShippingFreightFunction(shippingToFreight.getValue());
    }
}
