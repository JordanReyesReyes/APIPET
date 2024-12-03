package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetPets {
    public static Performable withState(String endpoint) {
        return Get.resource(endpoint);
    }
}

