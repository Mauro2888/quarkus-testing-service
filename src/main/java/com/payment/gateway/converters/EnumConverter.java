package com.payment.gateway.converters;

import com.payment.gateway.service.PaymentType;

/**
 * This class convert String from configuration to ENUM
 */
public class EnumConverter implements org.eclipse.microprofile.config.spi.Converter<PaymentType> {
    @Override
    public PaymentType convert(String s) throws IllegalArgumentException, NullPointerException {
        return PaymentType.valueOf(s.toUpperCase());
    }
}
