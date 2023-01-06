package com.payment.gateway.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class ContextPayment {

    private final Map<PaymentType,IPay> paymentTypeIPayMap;
    public ContextPayment(Instance<IPay> instance) {
        paymentTypeIPayMap = instance.stream()
                .collect(Collectors.toUnmodifiableMap(IPay::type, Function.identity()));
    }
    public String doPayment(int amount,PaymentType type){
        return paymentTypeIPayMap.get(type).pay(amount);
    }
}
