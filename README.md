# Spring Boot Microservices Demo Project

## Spring Boot Project As Employee Service

README: [employee-service](./employee-service/README.md)

## Spring Boot Project As Department Service

README: [department-service](./department-service/README.md)

## Spring Boot Project As Service Registry

README: [service-registry](./service-registry/README.md)

## Spring Boot Project As API Gateway

README: [api-gateway](./api-gateway/README.md)

## Spring Boot Project As Config Server

README: [config-server](./config-server/README.md)

## Docker Compose for MySql-Server

[docker-compose.yml](local-db/mysql/docker-compose.yml)

```bash
# Change Directory to MySql-Server
cd local-db/mysql
```

```bash
# Start MySql-Server
docker compose up -d
```

```bash
# Stop MySql-Server and Remove MySql-Server with Volumes
docker compose down -v
```

## Microservices Communication

- [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
- [WebClient](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/reactive/function/client/WebClient.html)
- [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)

### API Gateway

- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

- Route Request
- Load Balance
- Security

### Spring Cloud Config Server

- [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)