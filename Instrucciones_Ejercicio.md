# Práctica Bankaya — Requerimientos

Fecha límite: jueves 18 de septiembre

## Puntos a cumplir

1. Subir el proyecto a un repositorio.
2. Agregar un README con las instrucciones para validar el desarrollo.
3. Contar con una estrategia de branching (GitFlow o similar).
4. Desarrollo:
    - Consumir la API pública: https://pokeapi.co/
    - En base a lo que retorna crear un endpoint en SOAP con los siguientes métodos:
        - abilities
        - base_experience
        - held_items
        - id
        - name
        - location_area_encounters

      NOTA: tienen que aceptar un parametro String,que sera el nombre del pokemon

5. Se tiene que guardar en una BD h2,mysql,etc.

    - Los request de las peticiones guardando como variables:

   ● ip de origin
   ● fecha de request
   ● método que se ejecuta

Variables opcionales:
tiempo duración de la petición
request
response


6. Parte del entregable como requerido:
   analisis con sonarqube
   pruebas unitarias
   cucumber


7. Adicionales:
   dockerizar el proyecto
   swagger
   patrones de diseño alterno a MVC