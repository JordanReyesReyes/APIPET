package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeletePet {
    public static Performable fromEndpoint(String endpoint) {
        return Delete.from(endpoint);
    }
}
