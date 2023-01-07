package com.payment.gateway.service;

import com.payment.gateway.model.PaymentResponse;
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
    Instance<IPay<PaymentResponse>> instance;

    @Test
    void testContextPayment(){


        instance.stream().forEach(iPay -> {
            assertEquals("ApplePay 100",contextPayment.doPayment(100,"EUR",PaymentType.APPLE));
        });
    }

    @Test
    public void testDoPayment() {

        String apple = (String) contextPayment.doPayment(100,"EUR", PaymentType.fromString("apple"));
        String payPal = (String) contextPayment.doPayment(100,"EUR", PaymentType.fromString("paypal"));
        assertEquals("PayPal 100", payPal);
        assertEquals("ApplePay 100", apple);
    }
}