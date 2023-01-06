package com.payment.gateway.service;

import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ContextPaymentTest {

    @Inject
    protected ContextPayment contextPayment;

    @Inject
    Instance<IPay> instance;

    @Test
    void testContextPayment(){


        instance.stream().forEach(iPay -> {
            assertEquals("ApplePay 100",contextPayment.doPayment(100,PaymentType.APPLE));
        });
    }

    @Test
    public void testDoPayment() {

        String apple = contextPayment.doPayment(100, PaymentType.fromString("apple"));
        String payPal = contextPayment.doPayment(100, PaymentType.fromString("paypal"));
        assertEquals("PayPal 100", payPal);
        assertEquals("ApplePay 100", apple);
    }
}