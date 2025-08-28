# Stage 1: Build
FROM eclipse-temurin:17-jdk AS build

# Diretório de trabalho
WORKDIR /app

# Copia arquivos de configuração do Maven Wrapper e POM
COPY mvnw .
COPY .mvn/ .mvn
COPY product-catalog-service/pom.xml product-catalog-service/pom.xml

# Baixa dependências
RUN ./mvnw -f product-catalog-service/pom.xml dependency:go-offline -B

# Copia todo o módulo para dentro do container
COPY product-catalog-service/src ./product-catalog-service/src

# Build do JAR
RUN ./mvnw -f product-catalog-service/pom.xml clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jdk

# Diretório de trabalho
WORKDIR /app

# Copia o JAR final do build
COPY --from=build /app/product-catalog-service/target/product-catalog-service-1.0.0.jar app.jar

# Porta exposta
EXPOSE 8080

# Variáveis de ambiente
ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS=""

# Comando para iniciar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
