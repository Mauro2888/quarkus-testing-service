package com.payment.gateway.service;

public interface IPay {
    String pay(int amount);

    PaymentType type();
}
