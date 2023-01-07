package com.payment.gateway.configuration;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
@ApplicationScoped
public class CurrencyConfig {

    @ConfigProperty(name = "currency.supported")
    List<String> supportedCurrency;

    public List<String> getSupportedCurrency() {
        return supportedCurrency;
    }

    public void setSupportedCurrency(List<String> supportedCurrency) {
        this.supportedCurrency = supportedCurrency;
    }
}
