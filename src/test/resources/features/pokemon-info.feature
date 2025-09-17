Feature: Obtener nombre de Pokémon

  Scenario: Consultar nombre por API
    Given El nombre del pokemon es "pikachu"
    When Consulta el nombre del pokemon
    Then El resultado debe ser "pikachu"

  Scenario: Obtener nombre de un Pokémon por nombre
    Given El nombre del pokemon es "bulbasaur"
    When Consulta el nombre pokemon por nombre pokemon
    Then El resultado nombre pokemon por nombre pokemon "bulbasaur"

  Scenario: Obtener Id de un Pokémon por nombre
    Given El nombre del pokemon es "bulbasaur"
    When Consulta el Id pokemon por nombre pokemon
    Then El resultado Id pokemon por nombre pokemon 1

  Scenario: Obtener baseExperience de un Pokémon por nombre
    Given El nombre del pokemon es "pikachu"
    When Consulta el baseExperience pokemon por nombre pokemon
    Then El resultado baseExperience pokemon por nombre pokemon 112

  Scenario: Obtener Abilities de un Pokémon por nombre
    Given El nombre del pokemon es "bulbasaur"
    When Consulta el Abilities pokemon por nombre pokemon
    Then El resultado Abilities pokemon por nombre pokemon
        | overgrow |
        | chlorophyll |
  Scenario: Obtener HeldItem de un Pokémon por nombre
    Given El nombre del pokemon es "pikachu"
    When Consulta el HeldItems pokemon por nombre pokemon
    Then El resultado HeldItems pokemon por nombre pokemon
      | oran-berry |
      | light-ball |

  Scenario: Obtener locationAreaEncounters de un Pokémon por nombre
    Given El nombre del pokemon es "bulbasaur"
    When Consulta el locationAreaEncounters pokemon por nombre pokemon
    Then El resultado locationAreaEncounters pokemon por nombre pokemon "https://pokeapi.co/api/v2/pokemon/1/encounters"
