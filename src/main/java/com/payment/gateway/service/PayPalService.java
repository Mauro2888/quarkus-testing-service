package com.payment.gateway.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PayPalService implements IPay{

    @Override
    public String pay(int amount) {
      return "PayPal " + amount;
    }

    @Override
    public PaymentType type() {
        return PaymentType.PAYPAL;
    }
}
