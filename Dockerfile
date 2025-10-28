# Etapa 1 — Build da aplicação
FROM ubuntu:latest AS build

# Atualizar pacotes e instalar dependências necessárias
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk wget unzip

# Definir diretório de trabalho
WORKDIR /app

# Copiar os arquivos do projeto para dentro da imagem
COPY . .

# Garantir permissão de execução ao Gradle Wrapper
RUN chmod +x gradlew

# Construir o projeto (sem testes para agilizar)
RUN ./gradlew clean build -x test

# Etapa 2 — Runtime (imagem final mais leve)
FROM ubuntu:latest

# Instalar apenas o Java para rodar o app
RUN apt-get update && \
    apt-get install -y openjdk-21-jre && \
    apt-get clean && rm -rf /var/lib/apt/lists/*

# Definir diretório de trabalho
WORKDIR /app

# Copiar o JAR da etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Comando para rodar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
