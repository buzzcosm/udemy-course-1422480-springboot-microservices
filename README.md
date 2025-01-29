# Spring Boot Microservices Demo Project

## Spring Boot Project As Employee Service

[employee-service](./employee-service/README.md)

## Spring Boot Project As Department Service

[department-service](./department-service/README.md)

## Docker Compose for MySql-Server

[docker-compose.yml](./database/mysql/docker-compose.yml)

```bash
# Change Directory to MySql-Server
cd database/mysql
```

```bash
# Start MySql-Server
docker compose up -d
```

```bash
# Stop MySql-Server and Remove MySql-Server with Volumes
docker compose down -v
```