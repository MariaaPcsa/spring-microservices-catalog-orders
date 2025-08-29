# Build stage
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copia o Maven Wrapper para Windows
COPY mvnw.cmd ./
COPY .mvn/ .mvn/
COPY pom.xml ./

# Baixa dependências offline
RUN cmd /c mvnw.cmd dependency:go-offline -B

# Copia o código-fonte
COPY src ./src

# Build do JAR
RUN cmd /c mvnw.cmd clean package -DskipTests

# ---------- Stage final ----------
FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
