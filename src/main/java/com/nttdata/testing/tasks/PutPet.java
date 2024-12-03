package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutPet {
    public static Performable withData(String endpoint, String body) {
        return Put.to(endpoint).with(request -> request.body(body).contentType("application/json"));
    }
}

