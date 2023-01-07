package com.payment.gateway.service;

public interface IPay<T> {
    T pay(int amount,String currency);

    PaymentType type();
}
