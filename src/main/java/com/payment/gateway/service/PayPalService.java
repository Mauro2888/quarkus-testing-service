package com.payment.gateway.service;

import com.payment.gateway.configuration.CurrencyConfig;
import com.payment.gateway.model.PaymentResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PayPalService implements IPay<PaymentResponse>{


    @Override
    public PaymentResponse pay(int amount,String currency) {
      return new PaymentResponse("PayPal",amount,currency);
    }

    @Override
    public PaymentType type() {
        return PaymentType.PAYPAL;
    }

}
