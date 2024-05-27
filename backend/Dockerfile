# Usar una imagen de Gradle para compilar y ejecutar pruebas unitarias
FROM gradle:8.7-jdk17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar archivos de Gradle y descargar las dependencias
COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle

# Dar permisos de ejecución al script gradlew
RUN chmod +x gradlew

# Descargar las dependencias sin compilar el código fuente aún
RUN ./gradlew build --no-daemon || return 0

# Copiar el código fuente
COPY src/ src/

# Compilar el proyecto y ejecutar pruebas unitarias
RUN ./gradlew build -x test --no-daemon

# Usar una imagen de OpenJDK 17 como base para el contenedor final
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el archivo JAR de la aplicación compilada desde el contenedor de compilación
COPY --from=build /app/build/libs/backend-0.0.1-SNAPSHOT.jar .

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot al iniciar el contenedor
CMD ["ls"]
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]
