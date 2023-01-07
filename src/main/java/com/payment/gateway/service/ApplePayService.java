package com.payment.gateway.service;

import com.payment.gateway.model.PaymentResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplePayService implements IPay<PaymentResponse>{
    @Override
    public PaymentResponse pay(int amount, String currency) {
        return new PaymentResponse("ApplePay ",amount,currency);
    }


    @Override
    public PaymentType type() {
        return PaymentType.APPLE;
    }
}
