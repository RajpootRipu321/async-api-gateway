package com.ripudaman.gateway;

import com.ripudaman.gateway.handler.GatewayHandler;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {

        Router router = Router.router(vertx);

        GatewayHandler gatewayHandler = new GatewayHandler(vertx);

        router.get("/")
                .handler(ctx -> ctx.response().end("Async API Gateway is Running!"));

        router.get("/aggregate")
                .handler(gatewayHandler::aggregate);

        vertx.createHttpServer()
                .requestHandler(router)
                .listen(8080)
                .onSuccess(server -> {
                    System.out.println("✅ Server started on port " + server.actualPort());
                    startPromise.complete();
                })
                .onFailure(startPromise::fail);
    }

    public static void main(String[] args) {
        Vertx.vertx().deployVerticle(new MainVerticle());
    }
}