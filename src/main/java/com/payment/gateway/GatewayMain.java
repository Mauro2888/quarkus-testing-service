package com.payment.gateway;


import com.payment.gateway.configuration.CurrencyConfig;
import com.payment.gateway.service.ContextPayment;
import com.payment.gateway.service.PaymentType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/pay")
public class GatewayMain {

    private final ContextPayment contextPayment;

    @ConfigProperty(name = "payment.supported")
    String supported;


    @Inject
    CurrencyConfig currencyConfig;

    public GatewayMain(ContextPayment contextPayment) {
        this.contextPayment = contextPayment;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object type(@QueryParam("type") String paymentType) {
        PaymentType type = PaymentType.fromString(paymentType);
        Optional<String> any = currencyConfig.getSupportedCurrency().stream().findAny();
        return contextPayment.doPayment(1000,any.get(),type);
    }

    @GET
    @Path("/currency")
    @Produces(MediaType.TEXT_PLAIN)
    public List<String> currency() {
        return currencyConfig.getSupportedCurrency();
    }
}