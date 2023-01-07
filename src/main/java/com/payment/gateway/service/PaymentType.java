package com.payment.gateway.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PaymentType {
    PAYPAL,APPLE;


    private static final Map<String,PaymentType> paymentTypesMap =
            Stream.of(PaymentType.values())
                    .collect(Collectors.toMap(PaymentType::name, Function.identity()));

    public static PaymentType fromString(String paymentType) {
        PaymentType type = paymentTypesMap.getOrDefault(paymentType.trim().toUpperCase(), null);
        if (Objects.isNull(type)) throw new IllegalArgumentException("Type not found");
        return type;
    }
}
