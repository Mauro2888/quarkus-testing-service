package com.payment.gateway.service;

import com.payment.gateway.model.PaymentResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class ContextPayment {

    private final Map<PaymentType,IPay<PaymentResponse>> paymentTypeIPayMap;
    public ContextPayment(Instance<IPay<PaymentResponse>> instance) {
        paymentTypeIPayMap = instance.stream()
                .collect(Collectors.toUnmodifiableMap(IPay::type, Function.identity()));
    }
    public Object doPayment(int amount, String currency, PaymentType type){
        IPay<PaymentResponse> iPayStrategy = paymentTypeIPayMap.getOrDefault(type,null);
        if (Objects.isNull(iPayStrategy)) throw new IllegalStateException("No payment method available");
        return  iPayStrategy.pay(amount,currency);
    }
}
