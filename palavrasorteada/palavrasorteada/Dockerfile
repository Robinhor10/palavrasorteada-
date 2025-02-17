# Stage 1: Build the application
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Instala o netcat (nc) dentro do container para que o wait-for.sh funcione
RUN apt-get update && apt-get install -y netcat && rm -rf /var/lib/apt/lists/*

# Copia o JAR construído na etapa de build
COPY --from=build /app/target/palavrasorteada-0.0.1-SNAPSHOT.jar app.jar

# Copia o script wait-for.sh para dentro do container
COPY wait-for.sh /wait-for.sh
RUN chmod +x /wait-for.sh

EXPOSE 8080

# Usa o script wait-for.sh para aguardar o DB (host "db" na porta 5432) antes de iniciar a aplicação
ENTRYPOINT ["/wait-for.sh", "db", "5432", "java", "-jar", "app.jar"]
