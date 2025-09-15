# pokemon-info-service
Servicio para obtener información de pokemons

# para levantar el servicio con docker-compose
Levanta la base de datos:
1. crear red (si no existe):
docker network create bancodb_network
1. docker-compose -f docker-compose-db.yml up -d --remove-orphans
2. Compila el proyecto:
mvn clean package
3. Levanta la app:
 - opción 1, primer plano: docker-compose -f docker-compose-app.yml up --build --remove-orphans
 - opción 2, segundo plano: docker-compose -f docker-compose-app.yml up --build -d


notas:
para eliminar el volumen creado,cuando se cambio el usuario o bd del archivo docker-compose-db.yml
docker-compose -f docker-compose-db.yml down -v


