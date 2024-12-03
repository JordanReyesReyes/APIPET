package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.GetPets;
import com.nttdata.testing.tasks.PostPet;
import com.nttdata.testing.tasks.PutPet;
import com.nttdata.testing.tasks.DeletePet;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetStepDefinitions {
    public static Logger LOGGER = LoggerFactory.getLogger(PetStepDefinitions.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint para obtener mascotas por estado")
    public void elActorEstableceElEndpointParaObtenerMascotasPorEstado(Actor actor) {
        actor.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @When("el {actor} envia una solicitud GET con el estado {string}")
    public void elActorEnviaUnaSolicitudGETConElEstado(Actor actor, String estado) {
        actor.attemptsTo(GetPets.withState("/pet/findByStatus?status=" + estado));
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));
    }

    @Given("el {actor} establece el endpoint POST para crear una mascota")
    public void elActorEstableceElEndpointPOSTParaCrearUnaMascota(Actor actor) {
        actor.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @When("el envia una solicitud HTTP POST con el {string} {string} {string}")
    public void elEnviaUnaSolicitudHTTPPOSTConEl(String id, String name, String status) {
        String petData = "{\"id\":" + id + ",\"name\":\"" + name + "\",\"status\":\"" + status + "\"}";
        theActorInTheSpotlight().attemptsTo(PostPet.withData("/pet", petData));
    }

    @Given("el {actor} establece el endpoint para actualizar una mascota")
    public void elActorEstableceElEndpointParaActualizarUnaMascota(Actor actor) {
        actor.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @When("el envia una solicitud HTTP PUT con el id {string} y los datos actualizados")
    public void elEnviaUnaSolicitudHTTPPUTConElIdYLosDatosActualizados(String id) {
        String updatedPetData = "{\"id\":" + id + ",\"name\":\"Updated Pet\",\"status\":\"pending\"}";
        theActorInTheSpotlight().attemptsTo(PutPet.withData("/pet", updatedPetData));
    }

    @Given("el {actor} establece el endpoint para eliminar una mascota")
    public void elActorEstableceElEndpointParaEliminarUnaMascota(Actor actor) {
        actor.whoCan(CallAnApi.at("https://petstore.swagger.io/v2"));
    }

    @When("el envia una solicitud HTTP DELETE con el id {string}")
    public void elEnviaUnaSolicitudHTTPDELETEConElId(String id) {
        theActorInTheSpotlight().attemptsTo(DeletePet.fromEndpoint("/pet/" + id));
    }
}

