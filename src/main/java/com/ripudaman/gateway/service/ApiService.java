package com.ripudaman.gateway.service;

import com.ripudaman.gateway.model.AggregateResponse;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.json.JsonObject;
public class ApiService {

    private final WebClient webClient;

    public ApiService(Vertx vertx) {
        this.webClient = WebClient.create(vertx);
    }

    public Future<AggregateResponse> getAggregatedResponse() {

        Future<JsonObject> postFuture = webClient
                .getAbs("https://jsonplaceholder.typicode.com/posts/1")
                .send()
                .map(response -> response.bodyAsJsonObject());

        Future<JsonObject> userFuture = webClient
                .getAbs("https://jsonplaceholder.typicode.com/users/1")
                .send()
                .map(response -> response.bodyAsJsonObject());

        return CompositeFuture
                .all(postFuture, userFuture)
                .map(composite -> {

                    JsonObject post = postFuture.result();
                    JsonObject user = userFuture.result();

                    return new AggregateResponse(
                            post.getString("title"),
                            user.getString("name")
                    );
                });
    }
}