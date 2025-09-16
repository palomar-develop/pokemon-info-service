# pokemon-info-service

Servicio para obtener información de pokémons.

---

## Levantar el servicio con Docker Compose

### 1. Levantar la base de datos

- **Crear red (si no existe):**
  ```bash
  docker network create pokemon_network
  ```

- **Iniciar la base de datos:**
  ```bash
  docker-compose -f docker-compose-db.yml up -d --remove-orphans
  ```

### 2. Compilar el proyecto

```bash
mvn clean package
```

### 3. Levantar la aplicación

- **Opción 1:** Primer plano
  ```bash
  docker-compose -f docker-compose-app.yml up --build --remove-orphans
  ```

- **Opción 2:** Segundo plano
  ```bash
  docker-compose -f docker-compose-app.yml up --build -d
  ```

---

## Notas

- Para eliminar el volumen creado (por ejemplo, si cambiaste el usuario o la base de datos en `docker-compose-db.yml`):

  ```bash
  docker-compose -f docker-compose-db.yml down -v
  ```

---

## Documentación de Calidad y Pruebas

### Reporte de Pruebas Unitarias (JUnit)

- El reporte generado por JUnit se encuentra en:
  - [`doc/Pruebas_JUnit/pokemon-info-service – Surefire Report.pdf`](doc/Pruebas_JUnit/pokemon-info-service%20–%20Surefire%20Report.pdf)

### Reporte de Pruebas de Integración (Cucumber)

- El reporte generado por Cucumber se encuentra en:
  - [`doc/Pruebas_Cucumber/Reporte_Cucumber.pdf`](doc/Pruebas_Cucumber/Reporte_Cucumber.pdf)

### Reporte de Calidad de Código (SonarQube)

- El reporte de análisis de calidad SonarQube se encuentra en:
  - [`doc/Evidencia_Sonar/pokemon-info-service_sonar.pdf`](doc/Evidencia_Sonar/pokemon-info-service_sonar.pdf)


## Diagrama Entidad-Relación (ER)

El diagrama ER de las entidades del servicio se encuentra en:

- [`doc/ER/pokemon-info-service_ER.pdf`](doc/ER/pokemon-info-service_ER.pdf)

También puedes visualizarlo como imagen:

- ![Diagrama ER](doc/ER/pokemon-info-service_ER.png)

---
## Documentación de Endpoints

Una vez levantado el proyecto, puedes acceder a:

- **Swagger UI (REST):** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **WSDL (SOAP):** [http://localhost:8080/ws/pokemon.wsdl](http://localhost:8080/ws/pokemon.wsdl)

