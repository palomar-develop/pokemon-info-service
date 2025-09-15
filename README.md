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
