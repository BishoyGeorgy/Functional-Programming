package com.fp.util;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/09/2021
 */
public class Configuration {

    public enum OrderToInvoice {
        INVOICE1(1), INVOICE2(2), INVOICE3(3);
        private int value;

        private OrderToInvoice(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum InvoiceToShipping {
        SHIPPING1(1), SHIPPING2(2), SHIPPING3(3), SHIPPING4(4), SHIPPING5(5);
        private int value;

        private InvoiceToShipping(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum ShippingToFreight {
        FREIGHT1(1), FREIGHT2(2), FREIGHT3(3);
        private int value;

        private ShippingToFreight(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum OrderToAvailabilty {
        AVAILABILTY1(1), AVAILABILTY2(2), AVAILABILTY3(3);
        private int value;

        private OrderToAvailabilty(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum AvailabilityToShippingDate {
        SHIPPING_DATE1(1), SHIPPING_DATE2(2), SHIPPING_DATE3(3), SHIPPING_DATE4(4);
        private int value;

        private AvailabilityToShippingDate(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
