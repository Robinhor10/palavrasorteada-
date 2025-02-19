# Stage 1: Build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o JAR construído na etapa de build
COPY --from=build /app/target/palavrasorteada-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Usa o script wait-for.sh para aguardar o DB (host "db" na porta 5432) antes de iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
