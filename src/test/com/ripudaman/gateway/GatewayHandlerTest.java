package com.ripudaman.gateway;

import com.ripudaman.gateway.handler.GatewayHandler;
import io.vertx.core.Vertx;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GatewayHandlerTest {

    @Test
    void shouldCreateGatewayHandler() {

        Vertx vertx = Vertx.vertx();

        GatewayHandler handler = new GatewayHandler(vertx);

        assertNotNull(handler);

        vertx.close();
    }
}