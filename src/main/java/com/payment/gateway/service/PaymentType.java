package com.payment.gateway.service;

import java.util.HashMap;
import java.util.Map;

public enum PaymentType {
    PAYPAL,APPLE;


    private static final Map<String,PaymentType> paymentTypesMap = new HashMap<>();
    
    static {
        for (PaymentType type : PaymentType.values()) {
            paymentTypesMap.put(type.name(), type);
        }
    }

    public static PaymentType fromString(String paymentType) {
        return paymentTypesMap.get(paymentType.toUpperCase());
    }
}
