package com.payment.gateway;


import com.payment.gateway.converters.EnumConverter;
import com.payment.gateway.service.*;
import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pay")
public class GatewayMain {

    private final ContextPayment contextPayment;

    @ConfigProperty(name = "payment.supported")
    String supported;

    public GatewayMain(ContextPayment contextPayment) {
        this.contextPayment = contextPayment;
    }

    @GET
    @Path("/to")
    @Produces(MediaType.TEXT_PLAIN)
    public String type(@QueryParam("type") String paymentType) {
        PaymentType type = PaymentType.fromString(paymentType);
        return contextPayment.doPayment(1000,type);
    }
}