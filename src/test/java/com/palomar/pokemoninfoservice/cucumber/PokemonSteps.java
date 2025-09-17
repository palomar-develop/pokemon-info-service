package com.palomar.pokemoninfoservice.cucumber;

import com.palomar.pokemoninfoservice.client.model.PokemonResponse;
import com.palomar.pokemoninfoservice.controller.PokemonSoapController;
import com.palomar.pokemoninfoservice.model.dto.*;
import com.palomar.pokemoninfoservice.service.PokemonApiService;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Autor: josue.palomar
 * Fecha de creación: 13/09/25
 */
@CucumberContextConfiguration
@SpringBootTest
public class PokemonSteps {
    private String pokemonName;
    private PokemonResponse response;
    private NameResponse  nameResponse;
    private AbilitiesResponse abilitiesResponse;
    private HeldItemResponse heldItemsResponse;
    private BaseExperienceResponse baseExperienceResponse;
    private IdResponse idResponse;
    private LocationAreaEncountersResponse locationAreaEncountersResponse;
    @Autowired
    private PokemonApiService service ; // Mockear en tests reales
    @Autowired
    private PokemonSoapController pokemonSOAPController; // Mockear en tests reales



    @Given("El nombre del pokemon es {string}")
    public void nombrePokemonAPI(String nombre) {
        this.pokemonName = nombre;
    }

    @When("Consulta el nombre del pokemon")
    public void consultaNombrePokemonAPI() {
        // Simulación, en tests reales usar mock
        response = service.getPokemonByName(pokemonName);

    }
    @Then("El resultado debe ser {string}")
    public void resultadoNombrePokemonAPI(String esperado) {
        assertEquals(esperado, response.getName());
    }

    //@Cuando("consulto el pokemon por SOAP")
    @When("Consulta el nombre pokemon por nombre pokemon")
    public void consultaNombrePokemonPorNombrePokemon() {
        nameResponse = pokemonSOAPController.handleName(pokemonName);
    }

    @Then("El resultado nombre pokemon por nombre pokemon {string}")
    public void resultadoNombrePokemonPorNombrePokemon(String esperado) {
        assertEquals(esperado, nameResponse.getName());
    }
    @When("Consulta el Id pokemon por nombre pokemon")
    public void consultaIdPokemonPorNombrePokemon() {
        idResponse = pokemonSOAPController.handleId(pokemonName);
    }

    @Then("El resultado Id pokemon por nombre pokemon {int}")
    public void resultadoIdPokemonPorNombrePokemon(Integer esperado) {
        assertEquals(esperado, idResponse.getId());
    }

    @When("Consulta el baseExperience pokemon por nombre pokemon")
    public void consultaBaseExperiencePokemonPorNombrePokemon() {
        baseExperienceResponse = pokemonSOAPController.handleBaseExperience(pokemonName);
    }

    @Then("El resultado baseExperience pokemon por nombre pokemon {int}")
    public void resultadoBaseExperiencePokemonPorNombrePokemon(Integer esperado) {
        assertEquals(esperado, baseExperienceResponse.getBaseExperience());
    }


    @When("Consulta el Abilities pokemon por nombre pokemon")
    public void consultaElAbilitiesPokemonPorNombrePokemon() {
        abilitiesResponse = pokemonSOAPController.handleAbilities(pokemonName);
    }

    @Then("El resultado Abilities pokemon por nombre pokemon")
    public void resultadoAbilitiesPokemonPorNombrePokemon(DataTable dataTable) {
        List<String> esperado = dataTable.asList();
        List<String> actual = abilitiesResponse.getAbilities().stream()
                .map(ability -> ability.getAbility().getName())
                .toList();
        assertEquals(esperado, actual);
    }

    @When("Consulta el HeldItems pokemon por nombre pokemon")
    public void consultaHeldItemsPokemonPorNombrePokemon() {
        // Aquí deberías llamar al servicio o controlador real
        heldItemsResponse = pokemonSOAPController.handleHeldItem(pokemonName);
    }

    @Then("El resultado HeldItems pokemon por nombre pokemon")
    public void resultadoHeldItemsPokemonPorNombrePokemon(DataTable dataTable) {
        List<String> esperado = dataTable.asList();
        List<String> actual = heldItemsResponse.getHeldItem().stream()
                .map(heldItem -> heldItem.getItem().getName())
                .toList();
        assertEquals(esperado, actual);
    }

    @When("Consulta el locationAreaEncounters pokemon por nombre pokemon")
    public void consultalocationAreaEncountersPokemonPorNombrePokemon() {
        locationAreaEncountersResponse = pokemonSOAPController.handleLocationAreaEncounters(pokemonName);
    }

    @Then("El resultado locationAreaEncounters pokemon por nombre pokemon {string}")
    public void resultadolocationAreaEncountersPokemonPorNombrePokemon(String esperado) {
        assertEquals(esperado, locationAreaEncountersResponse.getLocationAreaEncounters());
    }


}
