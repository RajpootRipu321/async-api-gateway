package com.ripudaman.gateway.handler;

import com.ripudaman.gateway.service.ApiService;
import com.ripudaman.gateway.util.JsonUtil;
import io.vertx.core.Vertx;
import io.vertx.ext.web.RoutingContext;

public class GatewayHandler {

    private final ApiService apiService;

    public GatewayHandler(Vertx vertx) {
        this.apiService = new ApiService(vertx);
    }

    public void aggregate(RoutingContext ctx) {

        apiService.getAggregatedResponse()

                .onSuccess(response -> {
                    ctx.response()
                            .putHeader("Content-Type", "application/json")
                            .end(JsonUtil.toJson(response));
                })

                .onFailure(error -> {
                    ctx.response()
                            .setStatusCode(500)
                            .putHeader("Content-Type", "application/json")
                            .end("""
                                    {
                                      "error":"Unable to fetch external services"
                                    }
                                    """);
                });
    }
}