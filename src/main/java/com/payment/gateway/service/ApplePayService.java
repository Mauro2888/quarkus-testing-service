package com.payment.gateway.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplePayService implements IPay{
    @Override
    public String pay(int amount) {
        return "ApplePay " + amount;
    }

    @Override
    public PaymentType type() {
        return PaymentType.APPLE;
    }
}
