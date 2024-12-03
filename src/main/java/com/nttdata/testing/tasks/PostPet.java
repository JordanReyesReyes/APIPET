package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostPet {
    public static Performable withData(String endpoint, String body) {
        return Post.to(endpoint).with(request -> request.body(body).contentType("application/json"));
    }
}


